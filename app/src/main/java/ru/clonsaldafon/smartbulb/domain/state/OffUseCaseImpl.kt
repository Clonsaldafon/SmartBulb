package ru.clonsaldafon.smartbulb.domain.state

import ru.clonsaldafon.smartbulb.data.repository.StateRepository
import javax.inject.Inject

class OffUseCaseImpl @Inject constructor(
    private val repository: StateRepository
) : OffUseCase {

    override suspend fun invoke(): Result<Boolean?> =
        repository.off()

}