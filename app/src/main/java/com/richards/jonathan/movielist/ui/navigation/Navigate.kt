package com.richards.jonathan.movielist.ui.navigation

sealed class Navigate {

    object MainMenu : Navigate()

    object TopMovies : Navigate()

    object SearchMovie : Navigate()

    object FavouriteMovies : Navigate()

}