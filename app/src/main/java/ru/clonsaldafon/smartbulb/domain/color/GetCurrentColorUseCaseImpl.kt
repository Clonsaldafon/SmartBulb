package ru.clonsaldafon.smartbulb.domain.color

import ru.clonsaldafon.smartbulb.data.model.Color
import ru.clonsaldafon.smartbulb.data.repository.ColorRepository
import javax.inject.Inject

class GetCurrentColorUseCaseImpl @Inject constructor(
    private val repository: ColorRepository
) : GetCurrentColorUseCase {

    override suspend fun invoke(): Result<Color?> =
        repository.getCurrentColor()

}