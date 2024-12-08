package ru.clonsaldafon.smartbulb.domain.state

interface OnUseCase {

    suspend operator fun invoke(): Result<Boolean?>

}