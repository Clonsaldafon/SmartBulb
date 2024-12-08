package ru.clonsaldafon.smartbulb.domain.state

interface GetStateUseCase {

    suspend operator fun invoke(): Result<Boolean?>

}