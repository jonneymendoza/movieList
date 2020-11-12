package com.richards.jonathan.movielist.domain.usecase

import com.richards.jonathan.movielist.data.entity.MovieListResponse
import com.richards.jonathan.movielist.domain.repository.MovieRepositoryContract
import kotlinx.coroutines.Deferred
import retrofit2.Response

class ShowTopRatingUseCase constructor(private val movieRepository: MovieRepositoryContract) {

    fun getTopRatedMovies(language: String, sortType: String): Deferred<Response<MovieListResponse>> {
        return movieRepository.getTopTenMovies(language, sortType)
    }
}
