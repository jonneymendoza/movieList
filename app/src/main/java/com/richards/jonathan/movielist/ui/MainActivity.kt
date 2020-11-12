package com.richards.jonathan.movielist.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.ui.tooling.preview.Preview
import com.richards.jonathan.movielist.R
import com.richards.jonathan.movielist.ui.data.MovieItemData
import com.richards.jonathan.movielist.ui.view.MovieListItem
import com.squareup.picasso.Picasso
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private  val picasso: Picasso by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity_layout)
        setSupportActionBar(findViewById(R.id.toolbar))

        initiateView()

    }

    private fun initiateView() {
        val fragment = MainMenuFragment()
        supportFragmentManager.beginTransaction()
                .add(R.id.fragment_content, fragment, fragment.javaClass.simpleName).commit()
    }

    fun goTo(page: Navigate) {
        when (page) {
            is Navigate.TopMovies -> {
                navigateToFragment(TopMoviesFragment())
            }
            is Navigate.MainMenu -> TODO()
            Navigate.SearchMovie -> TODO()
            Navigate.FavouriteMovies -> TODO()
        }
    }

    private fun navigateToFragment(fragment: BaseFragment) {
        supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_content, fragment)
                .addToBackStack(null)
                .commit()
    }

    @Preview
    @Composable
    fun testOne(){
        val movieItemData = MovieItemData("umageUrl","Tenet","22/12/20","genra", "2")

        MovieListItem(movieItemData, picasso).getMovieListItemView()
    }
}