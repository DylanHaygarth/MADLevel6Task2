package com.example.madlevel6task2.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.example.madlevel6task2.R
import com.example.madlevel6task2.model.Movie
import com.example.madlevel6task2.viewmodel.MoviesViewModel
import kotlinx.android.synthetic.main.fragment_movie_information.*

class MovieInformationFragment : Fragment() {
    private val viewModel: MoviesViewModel by activityViewModels()
    private lateinit var currentMovie : Movie

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_information, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
    }

    private fun initViews () {
        currentMovie = viewModel.currentMovie.value!!

        Glide.with(requireContext()).load(currentMovie.getPosterURL()).into(ivMovie)
        Glide.with(requireContext()).load(currentMovie.getBackDropURL()).into(ivPoster)
        tvDate.text = currentMovie?.releaseDate
        tvOverview.text = currentMovie?.overview
        tvTitle.text = currentMovie?.title
        tvRating.text = currentMovie?.rating.toString()
    }
}