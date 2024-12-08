package ru.clonsaldafon.smartbulb.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.clonsaldafon.smartbulb.UiState
import ru.clonsaldafon.smartbulb.data.model.Color
import ru.clonsaldafon.smartbulb.domain.color.GetAllColorsUseCase
import ru.clonsaldafon.smartbulb.domain.color.GetCurrentColorUseCase
import ru.clonsaldafon.smartbulb.domain.color.GetNamesOnlyUseCase
import ru.clonsaldafon.smartbulb.domain.color.SetColorUseCase
import ru.clonsaldafon.smartbulb.toUiState
import javax.inject.Inject

class ColorViewModel @Inject constructor(
    private val getAllColorsUseCase: GetAllColorsUseCase,
    private val setColorUseCase: SetColorUseCase,
    private val getNamesOnlyUseCase: GetNamesOnlyUseCase,
    private val getCurrentColorUseCase: GetCurrentColorUseCase
) : ViewModel() {

    private val _colors = MutableLiveData<UiState<List<Color>?>>(UiState.Loading)
    val colors: LiveData<UiState<List<Color>?>>
        get() = _colors

    private val _currentColor = MutableLiveData<UiState<Color?>>(UiState.Loading)
    val currentColor: LiveData<UiState<Color?>>
        get() = _currentColor

    init {
        loadColors()
        loadCurrentColor()
    }

    fun loadColors() {
        viewModelScope.launch {
            val result = getAllColorsUseCase()
            _colors.postValue(result.toUiState())
        }
    }

    fun setColor(color: String) {
        viewModelScope.launch {
            setColorUseCase(color)
        }
    }

    fun loadCurrentColor() {
        viewModelScope.launch {
            val result = getCurrentColorUseCase()
            _currentColor.postValue(result.toUiState())
        }
    }

}