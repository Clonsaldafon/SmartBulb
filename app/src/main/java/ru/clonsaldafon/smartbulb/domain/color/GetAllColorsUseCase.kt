package ru.clonsaldafon.smartbulb.domain.color

import ru.clonsaldafon.smartbulb.data.model.Color

interface GetAllColorsUseCase {

    suspend operator fun invoke(): Result<List<Color>?>

}