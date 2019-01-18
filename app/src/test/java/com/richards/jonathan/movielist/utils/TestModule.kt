package com.richards.jonathan.movielist.utils

import com.richards.jonathan.movielist.data.network.MovieNetworkController
import com.richards.jonathan.movielist.data.network.NetworkHelper
import com.richards.jonathan.movielist.data.network.contract.MovieNetworkControllerContract
import com.richards.jonathan.movielist.data.network.contract.NetworkHelperContract
import com.richards.jonathan.movielist.domain.repository.MovieRepository
import com.richards.jonathan.movielist.domain.repository.MovieRepositoryContract
import com.richards.jonathan.movielist.domain.usecase.ShowTopRatingUseCase
import org.koin.dsl.module.module
import org.mockito.Mockito

object TestModule {
    fun getTestModules() = module {
        factory<MovieRepositoryContract> { MovieRepository(get()) }
        single<NetworkHelperContract> {NetworkTestHelper() }
        single<MovieNetworkControllerContract> { MovieNetworkController(get()) }
        factory { ShowTopRatingUseCase(get()) }
    }
}