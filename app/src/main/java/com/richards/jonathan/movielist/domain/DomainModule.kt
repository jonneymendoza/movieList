package com.richards.jonathan.movielist.domain

import com.richards.jonathan.movielist.domain.repository.MovieRepository
import com.richards.jonathan.movielist.domain.repository.MovieRepositoryContract
import org.koin.dsl.module.module

val movieRepositoryModule = module {
    factory<MovieRepositoryContract> { MovieRepository(get()) }
}

