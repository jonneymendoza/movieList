package com.richards.jonathan.movielist.data.network

import com.richards.jonathan.movielist.data.network.contract.MovieNetworkControllerContract
import com.richards.jonathan.movielist.data.network.contract.NetworkHelperContract
import org.koin.dsl.module

var networkModule = module {
    single<NetworkHelperContract> { NetworkHelper() }
    single<MovieNetworkControllerContract> { MovieNetworkController(get()) }
}