package com.richards.jonathan.movielist.main

import android.app.Application
import org.koin.android.ext.android.startKoin

class MovieListApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(MainAppModule))
    }

}