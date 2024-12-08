package ru.clonsaldafon.smartbulb.data.service

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
import ru.clonsaldafon.smartbulb.data.model.Brightness

interface BrightnessService {

    @GET("/brightness/")
    suspend fun getLevels(): Response<Brightness>

    @POST("/brightness/")
    suspend fun setLevel(@Query("level") level: Int): Response<Boolean>

    @GET("/brightness/current")
    suspend fun getCurrentLevel(): Response<Int>

}