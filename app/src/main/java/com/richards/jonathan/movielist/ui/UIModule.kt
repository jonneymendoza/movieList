package com.richards.jonathan.movielist.ui

import com.richards.jonathan.movielist.domain.usecase.ShowTopRatingUseCase
import org.koin.androidx.viewmodel.dsl.viewModel

import org.koin.dsl.module

val uiModule = module {
    factory { ShowTopRatingUseCase(get()) }
    viewModel { MovieListViewModel(get()) }
}