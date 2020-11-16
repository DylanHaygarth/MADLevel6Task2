package com.example.madlevel6task2.service

import com.example.madlevel6task2.model.Movie
import retrofit2.http.GET

interface MovieAPIService {

    @GET("discover/movie?api_key=9e9dbe4ade6fef32bde272ae3a42e9b7&language=en-US&sort_by=popularity.desc")
    suspend fun getMovies() : List<Movie>
}