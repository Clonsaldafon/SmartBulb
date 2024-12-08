package ru.clonsaldafon.smartbulb.domain.color

import ru.clonsaldafon.smartbulb.data.repository.ColorRepository
import javax.inject.Inject

class SetColorUseCaseImpl @Inject constructor(
    private val repository: ColorRepository
) : SetColorUseCase {

    override suspend fun invoke(color: String): Result<Boolean?> =
        repository.setColor(color)

}