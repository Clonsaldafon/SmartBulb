package ru.clonsaldafon.smartbulb.domain.state

import ru.clonsaldafon.smartbulb.data.repository.StateRepository
import javax.inject.Inject

class GetStateUseCaseImpl @Inject constructor(
    private val repository: StateRepository
) : GetStateUseCase {

    override suspend fun invoke(): Result<Boolean?> =
        repository.getState()

}