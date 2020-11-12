package com.richards.jonathan.movielist.domain.repository

import com.richards.jonathan.movielist.data.entity.MovieListResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response

interface MovieRepositoryContract {

    fun getTopTenMovies(language: String, sortType: String): Deferred<Response<MovieListResponse>>
    fun searchMovie(title: String): Deferred<Response<MovieListResponse>>

}