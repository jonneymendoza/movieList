package com.richards.jonathan.movielist.domain.usecase

import com.richards.jonathan.movielist.data.entity.MovieList
import com.richards.jonathan.movielist.domain.repository.MovieRepositoryContract
import kotlinx.coroutines.Deferred
import retrofit2.Response

class ShowTopRatingUseCase constructor(private val movieRepository: MovieRepositoryContract) {

    suspend fun getTopRatedMovies(language: String, sortType: String): Deferred<Response<MovieList>> {
        return movieRepository.getTopTenMovies(language, sortType)
    }
}