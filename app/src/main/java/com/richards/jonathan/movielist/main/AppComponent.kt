package com.richards.jonathan.movielist.main

import com.richards.jonathan.movielist.data.network.networkModule
import com.richards.jonathan.movielist.domain.movieRepositoryModule
import com.richards.jonathan.movielist.ui.uiModule

object AppComponent {
    val getAllModules = listOf(MainAppModule,
            movieRepositoryModule,
            networkModule,
            uiModule)
}