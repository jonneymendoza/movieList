package com.richards.jonathan.movielist.ui.view

import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.ConstraintLayout
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.ui.tooling.preview.Preview
import com.husseinala.neon.core.Neon
import com.husseinala.neon.picasso.ProvidePicassoLoader
import com.richards.jonathan.movielist.ui.data.MovieItemData
import com.squareup.picasso.Picasso

class MovieListItem(private val movieItemData: MovieItemData, private val picasso: Picasso) {


    @Preview
    @Composable
    fun previewGetMovieListItemView(){
        getMovieListItemView()
    }

    @Composable
    fun getMovieListItemView() {

        ProvidePicassoLoader(picasso) {
            ConstraintLayout {
                val (movieImageView, titleView, ratingView, releaseDateView, genreView, ratingStarView) = createRefs()

                Neon(
                        url = movieItemData.imageUrl,
                        modifier = Modifier.constrainAs(movieImageView) {
                            top.linkTo(parent.top)
                            absoluteLeft.linkTo(parent.absoluteLeft)
                        })

                Text(text = "title", modifier = Modifier.constrainAs(titleView) {

                })

                Text(text = "title", modifier = Modifier.constrainAs(ratingView) {

                })

                Text(text = "title", modifier = Modifier.constrainAs(releaseDateView) {

                })

                Text(text = "title", modifier = Modifier.constrainAs(genreView) {

                })

                Text(text = "title", modifier = Modifier.constrainAs(ratingStarView) {

                })
            }
        }

    }
}
