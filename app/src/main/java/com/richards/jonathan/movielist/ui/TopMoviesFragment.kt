package com.richards.jonathan.movielist.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import com.richards.jonathan.movielist.R
import com.richards.jonathan.movielist.data.Status
import org.koin.android.ext.android.inject

class TopMoviesFragment : BaseFragment() {

    private val movieListViewModel: MovieListViewModel by inject()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.top_movies_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        //get top movies
        movieListViewModel.getTopMovies().observe(this, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    Log.d("JJJ", "SUCCESS we got some data!")
                    Log.d("JJJ", "amount of data fetched is " + it.data!!.totalResults)
                }
                Status.ERROR -> {
                    Toast.makeText(activity, "error", Toast.LENGTH_LONG)
                }
                Status.LOADING -> {
                    //Show some loading
                }
            }
        })

        //TODO: create recylerview adapter and map the data we get into the UI
    }
}