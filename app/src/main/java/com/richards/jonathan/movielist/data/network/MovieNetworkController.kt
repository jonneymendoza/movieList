package com.richards.jonathan.movielist.data.network

import com.google.gson.GsonBuilder
import com.richards.jonathan.movielist.BuildConfig
import com.richards.jonathan.movielist.data.entity.MovieList
import com.richards.jonathan.movielist.data.network.contract.MovieDbApi
import com.richards.jonathan.movielist.data.network.contract.MovieNetworkControllerContract
import com.richards.jonathan.movielist.data.network.contract.NetworkHelperContract
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MovieNetworkController constructor(var networkHelper: NetworkHelperContract) : MovieNetworkControllerContract {

    private fun getMovieDdApi(): MovieDbApi {
        val gson = GsonBuilder().setLenient().create()
        val httpClient = networkHelper.createHttpClient()
        val retrofit = Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()

        return retrofit.create(MovieDbApi::class.java)
    }

    override fun getTopTenMovies(language: String, sortType: String): Deferred<Response<MovieList>> {
        return getMovieDdApi().getTopTenMovies(BuildConfig.API_KEY, language, sortType, 1)
    }

    override fun searchMovie(title: String): Deferred<Response<MovieList>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}