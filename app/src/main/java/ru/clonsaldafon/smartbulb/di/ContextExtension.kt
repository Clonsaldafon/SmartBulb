package ru.clonsaldafon.smartbulb.di

import android.content.Context
import ru.clonsaldafon.smartbulb.MyApplication

val Context.appComponent: AppComponent
    get() = when(this) {
        is MyApplication -> appComponent
        else -> applicationContext.appComponent
    }