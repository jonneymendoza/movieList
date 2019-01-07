package com.richards.jonathan.movielist.data.entity

import com.google.gson.annotations.SerializedName

data class MovieItem(val id: String,
                     val video: Boolean,
                     @SerializedName("vote_rating") val voteRating: Int,
                     @SerializedName("poster_path") val posterPath: String,
                     val overview: String,
                     @SerializedName("release_date")
                     val releaseDate: String)