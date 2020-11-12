package com.richards.jonathan.movielist.domain.repository

import com.richards.jonathan.movielist.data.entity.MovieListResponse
import com.richards.jonathan.movielist.data.network.contract.MovieNetworkControllerContract
import kotlinx.coroutines.Deferred
import retrofit2.Response

class MovieRepository constructor(private val movieNetworkController: MovieNetworkControllerContract) : MovieRepositoryContract {
    override fun getTopTenMovies(language: String, sortType: String): Deferred<Response<MovieListResponse>> {
        return movieNetworkController.getTopTenMovies(language, sortType)
    }

    override fun searchMovie(title: String): Deferred<Response<MovieListResponse>> {
        return movieNetworkController.searchMovie(title)
    }
}