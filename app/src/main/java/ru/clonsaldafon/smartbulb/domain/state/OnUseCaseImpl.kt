package ru.clonsaldafon.smartbulb.domain.state

import ru.clonsaldafon.smartbulb.data.repository.StateRepository
import javax.inject.Inject

class OnUseCaseImpl @Inject constructor(
    private val repository: StateRepository
) : OnUseCase {

    override suspend fun invoke(): Result<Boolean?> =
        repository.on()

}