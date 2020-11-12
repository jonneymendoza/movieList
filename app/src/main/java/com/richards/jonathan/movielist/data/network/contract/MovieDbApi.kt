package com.richards.jonathan.movielist.data.network.contract

import com.richards.jonathan.movielist.data.entity.MovieListResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieDbApi {

    companion object {
        const val PARAM_API_KEY = "api_key"
        const val PARAM_LANGUAGE = "language"
        const val PARAM_SORT_BY = "sort_by"
        const val PARAM_PAGE = "page"
        const val PARAM_QUERY = "query"
    }

    @GET("discover/movie")
    fun getTopTenMovies(@Query(PARAM_API_KEY) apiKey : String,
                        @Query(PARAM_LANGUAGE) language : String,
                        @Query(PARAM_SORT_BY) sortType : String,
                        @Query(PARAM_PAGE) page : Int): Deferred<Response<MovieListResponse>>

    @GET("/search/")
    fun searchMovie(@Query(PARAM_API_KEY) apiKey : String, @Query(PARAM_QUERY) searchTerm : String) : Deferred<Response<MovieListResponse>>


}