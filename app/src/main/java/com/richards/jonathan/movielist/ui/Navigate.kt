package com.richards.jonathan.movielist.ui

sealed class Navigate {

    object MainMenu : Navigate()

    object TopMovies : Navigate()

    object SearchMovie : Navigate()

    object FavouriteMovies : Navigate()

}