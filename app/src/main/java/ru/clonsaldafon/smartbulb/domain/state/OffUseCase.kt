package ru.clonsaldafon.smartbulb.domain.state

interface OffUseCase {

    suspend operator fun invoke(): Result<Boolean?>

}