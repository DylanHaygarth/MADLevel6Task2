package com.example.madlevel6task2.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import androidx.lifecycle.Observer
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.madlevel6task2.R
import com.example.madlevel6task2.model.Movie
import com.example.madlevel6task2.viewmodel.MoviesViewModel
import kotlinx.android.synthetic.main.fragment_search_movie.*

class MovieInformationFragment : Fragment() {
    private val viewModel: MoviesViewModel by activityViewModels()

    private var movies = listOf<Movie>()
    private var moviesAdapter = MoviesAdapter(movies)

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
        rvMovies.layoutManager = GridLayoutManager(requireActivity(), 2, RecyclerView.VERTICAL, false)
        rvMovies.adapter = moviesAdapter

        observeMovies()
    }

    private fun observeMovies() {
        viewModel.movies.observe(viewLifecycleOwner, Observer {
            movies = it
        })
    }
}