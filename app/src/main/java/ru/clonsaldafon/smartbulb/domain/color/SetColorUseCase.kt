package ru.clonsaldafon.smartbulb.domain.color

interface SetColorUseCase {

    suspend operator fun invoke(color: String): Result<Boolean?>

}