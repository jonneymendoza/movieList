package com.richards.jonathan.movielist.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.richards.jonathan.movielist.R
import kotlinx.android.synthetic.main.main_menu_fragment.*

class MainMenuFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.main_menu_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showTopMovieBtn.setOnClickListener {
            activity.goTo(Navigate.TOP_MOVIES)
        }


    }
}