package ru.clonsaldafon.smartbulb.data.repository

interface StateRepository {

    suspend fun on(): Result<Boolean?>

    suspend fun off(): Result<Boolean?>

    suspend fun getState(): Result<Boolean?>

}