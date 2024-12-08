package ru.clonsaldafon.smartbulb.di

import dagger.Module
import ru.clonsaldafon.smartbulb.di.brightness.BrightnessBindsModule
import ru.clonsaldafon.smartbulb.di.color.ColorBindsModule
import ru.clonsaldafon.smartbulb.di.state.StateBindsModule
import ru.clonsaldafon.smartbulb.di.viewmodel.ViewModelModule

@Module(
    includes = [
        ViewModelModule::class,
        NetworkModule::class,
        StateBindsModule::class,
        ColorBindsModule::class,
        BrightnessBindsModule::class
    ]
)
class AppModule