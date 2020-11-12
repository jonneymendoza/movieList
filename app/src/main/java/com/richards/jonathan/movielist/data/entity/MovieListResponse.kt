package com.richards.jonathan.movielist.data.entity

import com.google.gson.annotations.SerializedName

data class MovieListResponse(val page: Int,
                             @SerializedName("total_results") val totalResults: Int,
                             @SerializedName("total_pages") val totalPages: Int,
                             val results: List<MovieItem>)