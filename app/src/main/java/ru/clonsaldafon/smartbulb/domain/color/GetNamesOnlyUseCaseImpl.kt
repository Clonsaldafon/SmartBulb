package ru.clonsaldafon.smartbulb.domain.color

import ru.clonsaldafon.smartbulb.data.repository.ColorRepository
import javax.inject.Inject

class GetNamesOnlyUseCaseImpl @Inject constructor(
    private val repository: ColorRepository
) : GetNamesOnlyUseCase {

    override suspend fun invoke(): Result<List<String>?> =
        repository.getNamesOnly()

}