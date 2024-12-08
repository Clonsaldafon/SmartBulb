package ru.clonsaldafon.smartbulb.domain.brightness

interface GetCurrentLevelUseCase {

    suspend operator fun invoke(): Result<Int?>

}