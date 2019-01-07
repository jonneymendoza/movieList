package com.richards.jonathan.movielist.data.network.contract

import com.richards.jonathan.movielist.data.entity.MovieList
import kotlinx.coroutines.Deferred
import retrofit2.Response

interface MovieNetworkControllerContract {

    fun getTopTenMovies(language: String, sortType: String): Deferred<Response<MovieList>>

    fun searchMovie(title: String): Deferred<Response<MovieList>>
}