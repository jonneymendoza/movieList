package com.richards.jonathan.movielist.data.network

import org.koin.dsl.module.module

var networkModule = module {
    single<NetworkHelperContract> {NetworkHelper()  }
}