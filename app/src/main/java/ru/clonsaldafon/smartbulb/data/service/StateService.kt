package ru.clonsaldafon.smartbulb.data.service

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST

interface StateService {

    @POST("/state/on")
    suspend fun on(): Response<Boolean>

    @POST("/state/off")
    suspend fun off(): Response<Boolean>

    @GET("/state/")
    suspend fun getState(): Response<Boolean>

}