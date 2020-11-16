package com.example.madlevel6task2.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.madlevel6task2.model.Movie
import com.example.madlevel6task2.repository.MovieRepository
import kotlinx.coroutines.launch

class MoviesViewModel(application: Application) : AndroidViewModel(application) {
    private val moviesRepository = MovieRepository()

    val movies: LiveData<List<Movie>> = moviesRepository.movies

    val currentMovie: MutableLiveData<Movie> = MutableLiveData()

    fun getMovies(year: Int) {
        viewModelScope.launch{
            moviesRepository.getMovies(year)
        }
    }

    fun setCurrentMovie(movie: Movie) {
        viewModelScope.launch{
            currentMovie.value = movie
        }
    }
}