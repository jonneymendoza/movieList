package com.richards.jonathan.movielist.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.richards.jonathan.movielist.data.Resource
import com.richards.jonathan.movielist.data.Status
import com.richards.jonathan.movielist.data.entity.MovieItem
import com.richards.jonathan.movielist.data.entity.MovieListResponse
import com.richards.jonathan.movielist.data.network.CallHandler
import com.richards.jonathan.movielist.domain.usecase.SearchMovieUseCase

class SearchMovieViewModel constructor(private val searchMovieUseCase: SearchMovieUseCase) : ViewModel() {

    private val responseStatus = MutableLiveData<Status>()

    private val movieList = MutableLiveData<List<MovieItem>>()

    private lateinit var searchMovies: MutableLiveData<Resource<MovieListResponse>>

    private val movieResultsObserver = Observer<Resource<MovieListResponse>> {
        when (it.status) {
            Status.Error -> responseStatus.postValue(Status.Error)
            Status.Loading -> responseStatus.postValue(Status.Loading)
            Status.Success -> {
                responseStatus.postValue(Status.Success)
                if (it.data != null) {
                    movieList.postValue(it.data.results)
                } else {
                    movieList.postValue(emptyList())
                }
            }
        }
    }

    fun searchMovies(title: String) {
        searchMovies = CallHandler<MovieListResponse>().makeCall(searchMovieUseCase.searchByTitle(title))
        searchMovies.observeForever(movieResultsObserver)
    }

    fun observeSearchStatus(): MutableLiveData<Status> {
        return responseStatus
    }

    fun observeSearchResults(): MutableLiveData<List<MovieItem>> {
        return movieList
    }

}