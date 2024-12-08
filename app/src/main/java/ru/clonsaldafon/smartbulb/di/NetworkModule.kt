package ru.clonsaldafon.smartbulb.di

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.clonsaldafon.smartbulb.data.service.BrightnessService
import ru.clonsaldafon.smartbulb.data.service.ColorService
import ru.clonsaldafon.smartbulb.data.service.StateService

@Module
class NetworkModule {

    companion object {

        private const val API_URL = "http://46.17.45.34:1337"

        private val retrofit = Retrofit.Builder()
            .baseUrl(API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        @Provides
        fun provideStateService(): StateService =
            retrofit.create(StateService::class.java)

        @Provides
        fun provideColorService(): ColorService =
            retrofit.create(ColorService::class.java)

        @Provides
        fun provideBrightnessService(): BrightnessService =
            retrofit.create(BrightnessService::class.java)

    }
}