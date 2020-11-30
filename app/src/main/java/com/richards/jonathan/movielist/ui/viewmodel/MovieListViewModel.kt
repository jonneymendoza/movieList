package com.richards.jonathan.movielist.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.richards.jonathan.movielist.data.Resource
import com.richards.jonathan.movielist.data.entity.MovieListResponse
import com.richards.jonathan.movielist.data.network.CallHandler
import com.richards.jonathan.movielist.domain.usecase.ShowTopRatingUseCase

class MovieListViewModel constructor(private val showTopRatingUseCase: ShowTopRatingUseCase) : ViewModel() {
    fun getTopMovies(): MutableLiveData<Resource<MovieListResponse>> {
        return CallHandler<MovieListResponse>().makeCall(showTopRatingUseCase.getTopRatedMovies("en-US", "popularity.desc"))
    }
}