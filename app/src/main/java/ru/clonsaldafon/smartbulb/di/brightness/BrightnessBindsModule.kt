package ru.clonsaldafon.smartbulb.di.brightness

import dagger.Binds
import dagger.Module
import ru.clonsaldafon.smartbulb.data.repository.BrightnessRepository
import ru.clonsaldafon.smartbulb.data.repository.BrightnessRepositoryImpl
import ru.clonsaldafon.smartbulb.domain.brightness.GetCurrentLevelUseCase
import ru.clonsaldafon.smartbulb.domain.brightness.GetCurrentLevelUseCaseImpl
import ru.clonsaldafon.smartbulb.domain.brightness.GetLevelsUseCase
import ru.clonsaldafon.smartbulb.domain.brightness.GetLevelsUseCaseImpl
import ru.clonsaldafon.smartbulb.domain.brightness.SetLevelUseCase
import ru.clonsaldafon.smartbulb.domain.brightness.SetLevelUseCaseImpl
import javax.inject.Singleton

@Module
interface BrightnessBindsModule {

    @Binds
    @Singleton
    fun bindBrightnessRepository(repository: BrightnessRepositoryImpl): BrightnessRepository

    @Binds
    @Singleton
    fun bindGetLevelsUseCase(useCase: GetLevelsUseCaseImpl): GetLevelsUseCase

    @Binds
    @Singleton
    fun bindSetLevelUseCase(useCase: SetLevelUseCaseImpl): SetLevelUseCase

    @Binds
    @Singleton
    fun bindGetCurrentLevelUseCase(useCase: GetCurrentLevelUseCaseImpl): GetCurrentLevelUseCase

}