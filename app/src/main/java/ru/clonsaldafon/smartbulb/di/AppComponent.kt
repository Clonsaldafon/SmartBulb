package ru.clonsaldafon.smartbulb.di

import dagger.Component
import ru.clonsaldafon.smartbulb.presentation.MainFragment
import javax.inject.Singleton

@Component(
    modules = [
        AppModule::class
    ]
)
@Singleton
interface AppComponent {
    fun inject(fragment: MainFragment)
}