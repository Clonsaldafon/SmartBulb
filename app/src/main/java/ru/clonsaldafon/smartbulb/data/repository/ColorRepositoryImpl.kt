package ru.clonsaldafon.smartbulb.data.repository

import retrofit2.HttpException
import ru.clonsaldafon.smartbulb.data.model.Color
import ru.clonsaldafon.smartbulb.data.service.ColorService
import javax.inject.Inject

class ColorRepositoryImpl @Inject constructor(
    private val service: ColorService
) : ColorRepository {

    override suspend fun getAllColors(): Result<List<Color>?> {
        kotlin.runCatching {
            service.getAllColors()
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

    override suspend fun setColor(color: String): Result<Boolean?> {
        kotlin.runCatching {
            service.setColor(color)
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

    override suspend fun getNamesOnly(): Result<List<String>?> {
        kotlin.runCatching {
            service.getNamesOnly()
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

    override suspend fun getCurrentColor(): Result<Color?> {
        kotlin.runCatching {
            service.getCurrentColor()
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