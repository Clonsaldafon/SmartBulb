package ru.clonsaldafon.smartbulb.data.repository

import retrofit2.HttpException
import ru.clonsaldafon.smartbulb.data.model.Brightness
import ru.clonsaldafon.smartbulb.data.service.BrightnessService
import javax.inject.Inject

class BrightnessRepositoryImpl @Inject constructor(
    private val service: BrightnessService
) : BrightnessRepository {

    override suspend fun getLevels(): Result<Brightness?> {
        kotlin.runCatching {
            service.getLevels()
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

    override suspend fun setLevel(level: Int): Result<Boolean?> {
        kotlin.runCatching {
            service.setLevel(level)
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

    override suspend fun getCurrentLevel(): Result<Int?> {
        kotlin.runCatching {
            service.getCurrentLevel()
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