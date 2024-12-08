package ru.clonsaldafon.smartbulb.data.repository

import ru.clonsaldafon.smartbulb.data.model.Brightness

interface BrightnessRepository {

    suspend fun getLevels(): Result<Brightness?>

    suspend fun setLevel(level: Int): Result<Boolean?>

    suspend fun getCurrentLevel(): Result<Int?>

}