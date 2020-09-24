package com.richards.jonathan.movielist.main

import android.app.Application
import org.koin.core.context.startKoin

class MovieListApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            AppComponent.getAllModules}
    }
}