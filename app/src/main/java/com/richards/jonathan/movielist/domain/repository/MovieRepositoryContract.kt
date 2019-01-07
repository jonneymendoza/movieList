package com.richards.jonathan.movielist.domain.repository

import com.richards.jonathan.movielist.data.entity.MovieList
import kotlinx.coroutines.Deferred
import retrofit2.Response

interface MovieRepositoryContract {

    fun getTopTenMovies(language: String, sortType: String): Deferred<Response<MovieList>>
    fun searchMovie(title: String): Deferred<Response<MovieList>>

}