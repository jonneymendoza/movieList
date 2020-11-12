package com.richards.jonathan.movielist.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Text
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.platform.ComposeView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.richards.jonathan.movielist.data.Resource
import com.richards.jonathan.movielist.data.Status
import com.richards.jonathan.movielist.data.entity.MovieItem
import com.richards.jonathan.movielist.data.entity.MovieListResponse
import com.richards.jonathan.movielist.ui.data.MovieItemData
import com.richards.jonathan.movielist.ui.view.MovieListItem
import com.squareup.picasso.Picasso
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class TopMoviesFragment : BaseFragment() {

    private val movieListViewModel: MovieListViewModel by viewModel()

    private val picasso: Picasso by inject()

    private val getTopMoviesLiveData = MutableLiveData<Resource<MovieListResponse>>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return ComposeView(requireContext()).apply {
            setContent {
                getTopMovies()
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        movieListViewModel.getTopMovies().observe(viewLifecycleOwner, Observer {
            getTopMoviesLiveData.postValue(it)
        })

    }

    @Composable
    fun getTopMovies() {
        val topMovies by getTopMoviesLiveData.observeAsState()
        when (topMovies?.status) {
            Status.Error -> Text(text = "error")
            Status.Loading -> Text(text = "Loading")
            Status.Success -> createMovieItemView(topMovies?.data?.results.orEmpty())
        }
    }

    @Composable
    private fun createMovieItemView(movieList: List<MovieItem>) {
        LazyColumnFor(items = movieList, itemContent = { movieItem ->
            Text(text = movieItem.title.orEmpty())
            MovieListItem(MovieItemData(movieItem.posterPath.orEmpty(),
                    movieItem.title.orEmpty(),
                    movieItem.releaseDate.orEmpty(),
                    "some genre", ""), picasso)

        })
    }
}