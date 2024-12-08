package ru.clonsaldafon.smartbulb.domain.color

import ru.clonsaldafon.smartbulb.data.model.Color
import ru.clonsaldafon.smartbulb.data.repository.ColorRepository
import javax.inject.Inject

class GetAllColorsUseCaseImpl @Inject constructor(
    private val repository: ColorRepository
) : GetAllColorsUseCase {

    override suspend fun invoke(): Result<List<Color>?> =
        repository.getAllColors()

}