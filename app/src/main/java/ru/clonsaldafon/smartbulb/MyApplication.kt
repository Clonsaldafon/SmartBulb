package ru.clonsaldafon.smartbulb

import android.app.Application
import ru.clonsaldafon.smartbulb.di.AppComponent
import ru.clonsaldafon.smartbulb.di.DaggerAppComponent

class MyApplication : Application() {

    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent
            .create()
    }

}