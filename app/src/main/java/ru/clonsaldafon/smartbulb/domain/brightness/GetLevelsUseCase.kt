package ru.clonsaldafon.smartbulb.domain.brightness

import ru.clonsaldafon.smartbulb.data.model.Brightness

interface GetLevelsUseCase {

    suspend operator fun invoke(): Result<Brightness?>

}