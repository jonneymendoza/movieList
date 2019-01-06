package com.richards.jonathan.movielist.data.network

import okhttp3.OkHttpClient

interface NetworkHelperContract {
    fun createHttpClient(): OkHttpClient
}