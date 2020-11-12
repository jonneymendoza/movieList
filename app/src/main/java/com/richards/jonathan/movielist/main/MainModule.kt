package com.richards.jonathan.movielist.main

import com.squareup.picasso.Picasso
import org.koin.dsl.module

/**
 * Define main common dependencies used across the app
 */
val MainAppModule = module {

    single { Picasso.Builder(get()).build() }
}