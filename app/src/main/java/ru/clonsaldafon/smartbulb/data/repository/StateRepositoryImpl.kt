package ru.clonsaldafon.smartbulb.data.repository

import retrofit2.HttpException
import ru.clonsaldafon.smartbulb.data.service.StateService
import javax.inject.Inject

class StateRepositoryImpl @Inject constructor(
    private val service: StateService
) : StateRepository {

    override suspend fun on(): Result<Boolean?> {
        kotlin.runCatching {
            service.on()
        }.fold(
            onSuccess = {
                return if (it.isSuccessful)
                    Result.success(it.body())
                else Result.failure(HttpException(it))
            },
            onFailure = {
                return Result.failure(it)
            }
        )
    }

    override suspend fun off(): Result<Boolean?> {
        kotlin.runCatching {
            service.off()
        }.fold(
            onSuccess = {
                return if (it.isSuccessful)
                    Result.success(it.body())
                else Result.failure(HttpException(it))
            },
            onFailure = {
                return Result.failure(it)
            }
        )
    }

    override suspend fun getState(): Result<Boolean?> {
        kotlin.runCatching {
            service.getState()
        }.fold(
            onSuccess = {
                return if (it.isSuccessful)
                    Result.success(it.body())
                else Result.failure(HttpException(it))
            },
            onFailure = {
                return Result.failure(it)
            }
        )
    }

}