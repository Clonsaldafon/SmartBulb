package ru.clonsaldafon.smartbulb.data.service

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
import ru.clonsaldafon.smartbulb.data.model.Color

interface ColorService {

    @GET("/color/")
    suspend fun getAllColors(): Response<List<Color>>

    @POST("/color/")
    suspend fun setColor(@Query("color") color: String): Response<Boolean>

    @GET("/color/names_only")
    suspend fun getNamesOnly(): Response<List<String>>

    @GET("/color/current")
    suspend fun getCurrentColor(): Response<Color>

}