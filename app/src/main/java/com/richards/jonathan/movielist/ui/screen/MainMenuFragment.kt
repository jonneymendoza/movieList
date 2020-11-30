package com.richards.jonathan.movielist.ui.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.richards.jonathan.movielist.databinding.MainMenuFragmentBinding
import com.richards.jonathan.movielist.ui.main.BaseFragment
import com.richards.jonathan.movielist.ui.navigation.Navigate


class MainMenuFragment : BaseFragment() {

    private var _binding: MainMenuFragmentBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        _binding = MainMenuFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.showTopMovieBtn.setOnClickListener {
            activity.goTo(Navigate.TopMovies)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}