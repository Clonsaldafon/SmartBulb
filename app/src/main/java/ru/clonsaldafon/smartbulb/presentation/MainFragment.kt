package ru.clonsaldafon.smartbulb.presentation

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.SeekBar
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.clonsaldafon.smartbulb.R
import ru.clonsaldafon.smartbulb.UiState
import ru.clonsaldafon.smartbulb.data.model.Brightness
import ru.clonsaldafon.smartbulb.data.model.Color
import ru.clonsaldafon.smartbulb.databinding.FragmentMainBinding
import ru.clonsaldafon.smartbulb.di.appComponent
import ru.clonsaldafon.smartbulb.di.viewmodel.ViewModelFactory
import ru.clonsaldafon.smartbulb.presentation.viewmodel.BrightnessViewModel
import ru.clonsaldafon.smartbulb.presentation.viewmodel.ColorViewModel
import ru.clonsaldafon.smartbulb.presentation.viewmodel.StateViewModel
import javax.inject.Inject

class MainFragment : Fragment(R.layout.fragment_main) {

    private val binding: FragmentMainBinding by viewBinding()

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val stateViewModel: StateViewModel by viewModels { viewModelFactory }
    private val colorViewModel: ColorViewModel by viewModels { viewModelFactory }
    private val brightnessViewModel: BrightnessViewModel by viewModels { viewModelFactory }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupObservers()
        setupListeners()
    }

    private fun setupObservers() {
        stateViewModel.state.observe(viewLifecycleOwner) {
            onStateDataReceived(it)
        }

        colorViewModel.currentColor.observe(viewLifecycleOwner) {
            onCurrentColorDataReceived(it)
        }
        colorViewModel.colors.observe(viewLifecycleOwner) {
            onColorsDataReceived(it)
        }

        brightnessViewModel.brightness.observe(viewLifecycleOwner) {
            onBrightnessDataReceived(it)
        }
        brightnessViewModel.currentLevel.observe(viewLifecycleOwner) {
            onCurrentBrightnessDataReceived(it)
        }
    }

    private fun setupListeners() = with(binding) {
        bulbEnabling.setOnCheckedChangeListener { _, b ->
            bulbEnablingText.text =
                if (b) getString(R.string.state_on)
                else getString(R.string.state_off)
            stateViewModel.changeState(b)
        }

        brightness.setOnSeekBarChangeListener(
            object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(bar: SeekBar?, progress: Int, fromUser: Boolean) {
                    bar?.progress = progress
                }

                override fun onStartTrackingTouch(bar: SeekBar?) {}

                override fun onStopTrackingTouch(bar: SeekBar?) {
                    bar?.let { brightnessViewModel.setLevel(it.progress) }
                }
            }
        )
    }

    private fun onStateDataReceived(data: UiState<Boolean?>?) = with(binding) {
        changeViewElementsVisibility(data)
        if (data is UiState.Success) {
            bulbEnabling.isChecked = data.value ?: false
            bulbEnablingText.text =
                if (data.value == true) getString(R.string.state_on)
                else getString(R.string.state_off)
        }
    }

    private fun onCurrentColorDataReceived(data: UiState<Color?>?) = with(binding) {
        changeViewElementsVisibility(data)
        if (data is UiState.Success)
            colors.hint = data.value?.name ?: getString(R.string.color)
    }

    private fun onColorsDataReceived(data: UiState<List<Color>?>?) {
        changeViewElementsVisibility(data)
        if (data is UiState.Success) {
            val colorNames = data.value?.map { it.name } ?: listOf()
            val adapter = ArrayAdapter(requireContext(), R.layout.color_item, colorNames)

            binding.colorItem.setAdapter(adapter)
            binding.colorItem.setOnItemClickListener { _, _, position, _ ->
                data.value?.get(position)?.let { color ->
                    colorViewModel.setColor(color.name)
                    binding.colors.hint = color.name
                }
            }
        }
    }

    private fun onBrightnessDataReceived(data: UiState<Brightness?>?) = with(binding) {
        changeViewElementsVisibility(data)
        if (data is UiState.Success) {
            brightness.min = data.value?.min ?: 0
            brightness.max = data.value?.max ?: 100
        }
    }

    private fun onCurrentBrightnessDataReceived(data: UiState<Int?>?) = with(binding) {
        changeViewElementsVisibility(data)
        if (data is UiState.Success)
            brightness.progress = data.value ?: 100
    }

    private fun <T> changeViewElementsVisibility(state: UiState<T>?) = with(binding) {
        when (state) {
            is UiState.Success -> {
                progress.visibility = View.GONE
                bulbEnablingText.visibility = View.VISIBLE
                bulbEnabling.visibility = View.VISIBLE
                colorText.visibility = View.VISIBLE
                colors.visibility = View.VISIBLE
                brightnessText.visibility = View.VISIBLE
                brightness.visibility = View.VISIBLE
                errorImage.visibility = View.GONE
                errorTitle.visibility = View.GONE
                errorSubtitle.visibility = View.GONE
            }
            is UiState.Failure -> {
                progress.visibility = View.GONE
                bulbEnablingText.visibility = View.GONE
                bulbEnabling.visibility = View.GONE
                colorText.visibility = View.GONE
                colors.visibility = View.GONE
                brightnessText.visibility = View.GONE
                brightness.visibility = View.GONE
                errorImage.visibility = View.VISIBLE
                errorTitle.visibility = View.VISIBLE
                errorSubtitle.visibility = View.VISIBLE
                errorSubtitle.text = state.message
            }
            is UiState.Loading -> {
                progress.visibility = View.VISIBLE
                bulbEnablingText.visibility = View.GONE
                bulbEnabling.visibility = View.GONE
                colorText.visibility = View.GONE
                colors.visibility = View.GONE
                brightnessText.visibility = View.GONE
                brightness.visibility = View.GONE
                errorImage.visibility = View.GONE
                errorTitle.visibility = View.GONE
                errorSubtitle.visibility = View.GONE
            }
            else -> {}
        }
    }

    override fun onAttach(context: Context) {
        context.appComponent.inject(this)
        super.onAttach(context)
    }
}