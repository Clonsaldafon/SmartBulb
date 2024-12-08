package ru.clonsaldafon.smartbulb.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.clonsaldafon.smartbulb.UiState
import ru.clonsaldafon.smartbulb.domain.state.GetStateUseCase
import ru.clonsaldafon.smartbulb.domain.state.OffUseCase
import ru.clonsaldafon.smartbulb.domain.state.OnUseCase
import ru.clonsaldafon.smartbulb.toUiState
import javax.inject.Inject

class StateViewModel @Inject constructor(
    private val onUseCase: OnUseCase,
    private val offUseCase: OffUseCase,
    private val getStateUseCase: GetStateUseCase
) : ViewModel() {

    private val _state = MutableLiveData<UiState<Boolean?>>(UiState.Loading)
    val state: LiveData<UiState<Boolean?>>
        get() = _state

    init {
        loadState()
    }

    fun loadState() {
        viewModelScope.launch {
            val result = getStateUseCase()
            _state.postValue(result.toUiState())
        }
    }

    fun changeState(state: Boolean) {
        viewModelScope.launch {
            if (state) onUseCase() else offUseCase()
        }
    }

}