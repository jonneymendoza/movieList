package com.richards.jonathan.movielist.data.entity

data class MovieList(val page: Long,
                     val totalResults: Long,
                     val totalPages: Long,
                     val results: MutableList<MovieItem>)