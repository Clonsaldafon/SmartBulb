package ru.clonsaldafon.smartbulb.domain.color

import ru.clonsaldafon.smartbulb.data.model.Color

interface GetCurrentColorUseCase {

    suspend operator fun invoke(): Result<Color?>

}