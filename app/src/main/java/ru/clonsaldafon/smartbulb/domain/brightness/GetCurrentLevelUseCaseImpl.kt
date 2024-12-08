package ru.clonsaldafon.smartbulb.domain.brightness

import ru.clonsaldafon.smartbulb.data.repository.BrightnessRepository
import javax.inject.Inject

class GetCurrentLevelUseCaseImpl @Inject constructor(
    private val repository: BrightnessRepository
) : GetCurrentLevelUseCase {

    override suspend fun invoke(): Result<Int?> =
        repository.getCurrentLevel()

}