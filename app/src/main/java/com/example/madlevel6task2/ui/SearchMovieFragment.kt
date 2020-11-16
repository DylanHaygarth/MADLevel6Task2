package com.example.madlevel6task2.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.madlevel6task2.R
import com.example.madlevel6task2.model.Movie
import com.example.madlevel6task2.viewmodel.MoviesViewModel
import kotlinx.android.synthetic.main.fragment_search_movie.*

class SearchMovieFragment : Fragment() {
    private val viewModel: MoviesViewModel by activityViewModels()

    private var movies = arrayListOf<Movie>()
    private var moviesAdapter = MoviesAdapter(movies)

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnSubmit.setOnClickListener {
            viewModel.getMovies(etYear.text.toString().toInt())
        }

        initViews()
    }

    private fun initViews () {
        rvMovies.layoutManager = GridLayoutManager(requireActivity(), 2)
        rvMovies.adapter = moviesAdapter

        observeMovies()
    }

    private fun observeMovies() {
        viewModel.movies.observe(viewLifecycleOwner, Observer {
            movies.clear()
            movies.addAll(it)
            moviesAdapter.notifyDataSetChanged()
        })
    }
}