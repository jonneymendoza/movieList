package com.richards.jonathan.movielist.data.entity

import com.google.gson.annotations.SerializedName

data class Movie(val hmePage : String, val id : String, @SerializedName("original_title") val title : String,
                 @SerializedName("overview") val overview : String,
                 @SerializedName("popularity") val popularity : Double,
                 @SerializedName("poster_path") val posterPath : String,
                 @SerializedName("release_date") val releaseDate : String,
                 @SerializedName("revenue") val revenue : Long,
                 @SerializedName("runtime") val runtime : Int,
                 @SerializedName("status") val status : String,
                 @SerializedName("vote_average") val rating : Double)