package ru.clonsaldafon.smartbulb.domain.brightness

interface SetLevelUseCase {

    suspend operator fun invoke(level: Int): Result<Boolean?>

}