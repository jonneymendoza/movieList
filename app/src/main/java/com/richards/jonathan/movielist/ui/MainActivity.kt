package com.richards.jonathan.movielist.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.richards.jonathan.movielist.R

class MainActivity : AppCompatActivity() {

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
            Navigate.TOP_MOVIES -> {
                navigateToFragment(TopMoviesFragment())
            }
            Navigate.MAIN_MENU -> TODO()
            Navigate.SEARCH_MOVIE -> TODO()
            Navigate.SHOW_FAVOURITES -> TODO()
        }
    }

    private fun navigateToFragment(fragment: BaseFragment) {
        supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_content, fragment)
                .addToBackStack(null)
                .commit()
    }
}