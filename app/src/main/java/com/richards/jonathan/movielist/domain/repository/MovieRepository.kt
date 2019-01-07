package com.richards.jonathan.movielist.domain.repository

import com.richards.jonathan.movielist.data.entity.MovieList
import com.richards.jonathan.movielist.data.network.contract.MovieNetworkControllerContract
import kotlinx.coroutines.Deferred
import retrofit2.Response

class MovieRepository constructor(val movieNetworkController: MovieNetworkControllerContract) : MovieRepositoryContract {
    override fun getTopTenMovies(language: String, sortType: String): Deferred<Response<MovieList>> {
        return movieNetworkController.getTopTenMovies(language, sortType)
    }

    override fun searchMovie(title: String): Deferred<Response<MovieList>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}