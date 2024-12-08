package ru.clonsaldafon.smartbulb.domain.brightness

import ru.clonsaldafon.smartbulb.data.model.Brightness
import ru.clonsaldafon.smartbulb.data.repository.BrightnessRepository
import javax.inject.Inject

class GetLevelsUseCaseImpl @Inject constructor(
    private val repository: BrightnessRepository
) : GetLevelsUseCase {

    override suspend fun invoke(): Result<Brightness?> =
        repository.getLevels()

}