package com.richards.jonathan.movielist.ui.view

import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.ConstraintLayout
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.husseinala.neon.core.Neon
import com.husseinala.neon.picasso.ProvidePicassoLoader
import com.richards.jonathan.movielist.ui.data.MovieItemData
import com.squareup.picasso.Picasso

class MovieListItem(private val movieItemData: MovieItemData, private val picasso: Picasso) {


    @Composable
    fun getMovieListItemView() {

        ProvidePicassoLoader(picasso) {

            MaterialTheme {
                ConstraintLayout {
                    val (movieImageView, titleView, ratingView, releaseDateView, genreView) = createRefs()

                    Neon(
                            url = movieItemData.imageUrl,
                            modifier = Modifier.constrainAs(movieImageView) {
                                top.linkTo(parent.top)
                                absoluteLeft.linkTo(parent.absoluteLeft)
                            }.padding(16.dp))

                    Text(text = movieItemData.movieTitle, modifier = Modifier.constrainAs(titleView) {
                        top.linkTo(movieImageView.top)
                        absoluteLeft.linkTo(movieImageView.absoluteRight)
                    })

                    Text(text = movieItemData.ratingScore, modifier = Modifier.constrainAs(ratingView) {
                        top.linkTo(titleView.bottom)
                        absoluteLeft.linkTo(movieImageView.absoluteRight)
                    })

                    Text(text = movieItemData.releaseData, modifier = Modifier.constrainAs(releaseDateView) {
                        top.linkTo(ratingView.bottom)
                        absoluteLeft.linkTo(movieImageView.absoluteRight)
                    })

                    Text(text = movieItemData.genre, modifier = Modifier.constrainAs(genreView) {
                        top.linkTo(releaseDateView.bottom)
                        absoluteLeft.linkTo(movieImageView.absoluteRight)
                    })
                }
            }

        }

    }
}
