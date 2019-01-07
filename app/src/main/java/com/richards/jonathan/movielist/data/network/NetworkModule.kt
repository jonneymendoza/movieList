package com.richards.jonathan.movielist.data.network

import com.richards.jonathan.movielist.data.network.contract.NetworkHelperContract
import org.koin.dsl.module.module

var networkModule = module {
    single<NetworkHelperContract> {NetworkHelper()  }
}