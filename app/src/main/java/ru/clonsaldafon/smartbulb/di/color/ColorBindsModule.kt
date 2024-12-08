package ru.clonsaldafon.smartbulb.di.color

import dagger.Binds
import dagger.Module
import ru.clonsaldafon.smartbulb.data.repository.ColorRepository
import ru.clonsaldafon.smartbulb.data.repository.ColorRepositoryImpl
import ru.clonsaldafon.smartbulb.domain.color.GetAllColorsUseCase
import ru.clonsaldafon.smartbulb.domain.color.GetAllColorsUseCaseImpl
import ru.clonsaldafon.smartbulb.domain.color.GetCurrentColorUseCase
import ru.clonsaldafon.smartbulb.domain.color.GetCurrentColorUseCaseImpl
import ru.clonsaldafon.smartbulb.domain.color.GetNamesOnlyUseCase
import ru.clonsaldafon.smartbulb.domain.color.GetNamesOnlyUseCaseImpl
import ru.clonsaldafon.smartbulb.domain.color.SetColorUseCase
import ru.clonsaldafon.smartbulb.domain.color.SetColorUseCaseImpl
import javax.inject.Singleton

@Module
interface ColorBindsModule {

    @Binds
    @Singleton
    fun bindColorRepository(repository: ColorRepositoryImpl): ColorRepository

    @Binds
    @Singleton
    fun bindGetAllColorsUseCase(useCase: GetAllColorsUseCaseImpl): GetAllColorsUseCase

    @Binds
    @Singleton
    fun bindSetColorUseCase(useCase: SetColorUseCaseImpl): SetColorUseCase

    @Binds
    @Singleton
    fun bindGetNamesOnlyUseCase(useCase: GetNamesOnlyUseCaseImpl): GetNamesOnlyUseCase

    @Binds
    @Singleton
    fun bindGetCurrentColorUseCase(useCase: GetCurrentColorUseCaseImpl): GetCurrentColorUseCase

}