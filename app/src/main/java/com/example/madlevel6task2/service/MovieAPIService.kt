package com.example.madlevel6task2.service

import com.example.madlevel6task2.model.Movie
import com.example.madlevel6task2.model.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieAPIService {

    @GET("discover/movie?api_key=9e9dbe4ade6fef32bde272ae3a42e9b7&language=en-US&sort_by=popularity.desc")
    suspend fun getMovies(@Query("year") year: Int) : MovieResponse
}