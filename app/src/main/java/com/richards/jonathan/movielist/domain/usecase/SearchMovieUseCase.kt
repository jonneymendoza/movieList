package com.richards.jonathan.movielist.domain.usecase

import com.richards.jonathan.movielist.data.entity.MovieListResponse
import com.richards.jonathan.movielist.domain.repository.MovieRepository
import com.richards.jonathan.movielist.domain.repository.MovieRepositoryContract
import kotlinx.coroutines.Deferred
import retrofit2.Response

class SearchMovieUseCase constructor( private val movieRepository: MovieRepositoryContract) {
    fun searchByTitle(title : String) :Deferred<Response<MovieListResponse>>{
        return movieRepository.searchMovie(title)
    }
    fun searchByDate(){

    }
}