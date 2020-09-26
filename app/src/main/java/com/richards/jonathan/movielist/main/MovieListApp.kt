package com.richards.jonathan.movielist.main

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MovieListApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            // Koin Android logger
            androidLogger()
            //inject Android context
            androidContext(this@MovieListApp)
            modules(AppComponent.getAllModules)}
    }
}