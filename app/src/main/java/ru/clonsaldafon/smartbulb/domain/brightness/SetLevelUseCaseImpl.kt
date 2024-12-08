package ru.clonsaldafon.smartbulb.domain.brightness

import ru.clonsaldafon.smartbulb.data.repository.BrightnessRepository
import javax.inject.Inject

class SetLevelUseCaseImpl @Inject constructor(
    private val repository: BrightnessRepository
) : SetLevelUseCase {

    override suspend fun invoke(level: Int): Result<Boolean?> =
        repository.setLevel(level)

}