package com.example.madlevel6task2.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.madlevel6task2.api.MoviesAPI
import com.example.madlevel6task2.model.Movie
import com.example.madlevel6task2.service.MovieAPIService
import kotlinx.coroutines.withTimeout

class MovieRepository {
    private val movieApiService: MovieAPIService = MoviesAPI.createApi()

    private val _movies: MutableLiveData<List<Movie>> = MutableLiveData()

    val movies: LiveData<List<Movie>>
        get() = _movies

    suspend fun getMovies(year: Int) {
        try {
            //timeout the request after 5 seconds
            val result = withTimeout(5000) {
                movieApiService.getMovies(year)
            }

            _movies.value = result.results
        } catch (error: Throwable) {
        }
    }
}
