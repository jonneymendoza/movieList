package com.richards.jonathan.movielist.data.network.contract

import okhttp3.OkHttpClient

interface NetworkHelperContract {
    fun createHttpClient(): OkHttpClient
}