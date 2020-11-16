package com.example.madlevel6task2.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.madlevel6task2.repository.MovieRepository
import kotlinx.coroutines.launch

class MoviesViewModel(application: Application) : AndroidViewModel(application) {
    private val moviesRepository = MovieRepository()

    /**
     * This property points direct to the LiveData in the repository, that value
     * get's updated when user clicks FAB. This happens through the getTriviaNumber() in this class :)
     */
    val movies = moviesRepository.movies

    fun getMovies() {
        viewModelScope.launch{
            moviesRepository.getMovies()
        }
    }
}