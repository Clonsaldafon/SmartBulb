package ru.clonsaldafon.smartbulb.domain.color

interface GetNamesOnlyUseCase {

    suspend operator fun invoke(): Result<List<String>?>

}