package com.richards.jonathan.movielist.ui

import com.richards.jonathan.movielist.domain.usecase.ShowTopRatingUseCase
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val uiModule = module {
    factory { ShowTopRatingUseCase(get()) }
    viewModel { MovieListViewModel(get()) }
}