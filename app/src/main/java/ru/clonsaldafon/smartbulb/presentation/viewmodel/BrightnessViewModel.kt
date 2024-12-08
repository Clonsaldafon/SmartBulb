package ru.clonsaldafon.smartbulb.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.clonsaldafon.smartbulb.UiState
import ru.clonsaldafon.smartbulb.data.model.Brightness
import ru.clonsaldafon.smartbulb.domain.brightness.GetCurrentLevelUseCase
import ru.clonsaldafon.smartbulb.domain.brightness.GetLevelsUseCase
import ru.clonsaldafon.smartbulb.domain.brightness.SetLevelUseCase
import ru.clonsaldafon.smartbulb.toUiState
import javax.inject.Inject

class BrightnessViewModel @Inject constructor(
    private val getLevelsUseCase: GetLevelsUseCase,
    private val setLevelUseCase: SetLevelUseCase,
    private val getCurrentLevelUseCase: GetCurrentLevelUseCase
) : ViewModel() {

    private val _brightness = MutableLiveData<UiState<Brightness?>>(UiState.Loading)
    val brightness: LiveData<UiState<Brightness?>>
        get() = _brightness

    private val _currentLevel = MutableLiveData<UiState<Int?>>(UiState.Loading)
    val currentLevel: LiveData<UiState<Int?>>
        get() = _currentLevel

    init {
        loadLevels()
        loadCurrentLevel()
    }

    fun loadLevels() {
        viewModelScope.launch {
            val result = getLevelsUseCase()
            _brightness.postValue(result.toUiState())
        }
    }

    fun setLevel(level: Int) {
        viewModelScope.launch {
            setLevelUseCase(level)
        }
    }

    fun loadCurrentLevel() {
        viewModelScope.launch {
            val result = getCurrentLevelUseCase()
            _currentLevel.postValue(result.toUiState())
        }
    }

}