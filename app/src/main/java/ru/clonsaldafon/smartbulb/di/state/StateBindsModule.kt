package ru.clonsaldafon.smartbulb.di.state

import dagger.Binds
import dagger.Module
import ru.clonsaldafon.smartbulb.data.repository.StateRepository
import ru.clonsaldafon.smartbulb.data.repository.StateRepositoryImpl
import ru.clonsaldafon.smartbulb.domain.state.GetStateUseCase
import ru.clonsaldafon.smartbulb.domain.state.GetStateUseCaseImpl
import ru.clonsaldafon.smartbulb.domain.state.OffUseCase
import ru.clonsaldafon.smartbulb.domain.state.OffUseCaseImpl
import ru.clonsaldafon.smartbulb.domain.state.OnUseCase
import ru.clonsaldafon.smartbulb.domain.state.OnUseCaseImpl
import javax.inject.Singleton

@Module
interface StateBindsModule {

    @Binds
    @Singleton
    fun bindStateRepository(repository: StateRepositoryImpl): StateRepository

    @Binds
    @Singleton
    fun bindOnUseCase(useCase: OnUseCaseImpl): OnUseCase

    @Binds
    @Singleton
    fun bindOffUseCase(useCase: OffUseCaseImpl): OffUseCase

    @Binds
    @Singleton
    fun bindGetStateUseCase(useCase: GetStateUseCaseImpl): GetStateUseCase

}