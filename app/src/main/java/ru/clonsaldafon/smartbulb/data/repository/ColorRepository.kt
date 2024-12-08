package ru.clonsaldafon.smartbulb.data.repository

import ru.clonsaldafon.smartbulb.data.model.Color

interface ColorRepository {

    suspend fun getAllColors(): Result<List<Color>?>

    suspend fun setColor(color: String): Result<Boolean?>

    suspend fun getNamesOnly(): Result<List<String>?>

    suspend fun getCurrentColor(): Result<Color?>

}