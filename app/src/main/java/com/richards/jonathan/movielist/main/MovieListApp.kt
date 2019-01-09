package com.richards.jonathan.movielist.main

import android.app.Application
import com.richards.jonathan.movielist.data.network.networkModule
import com.richards.jonathan.movielist.domain.movieRepositoryModule
import com.richards.jonathan.movielist.ui.uiModule
import org.koin.android.ext.android.startKoin

class MovieListApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(MainAppModule,
                movieRepositoryModule,
                networkModule,
                uiModule))
    }

}