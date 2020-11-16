package com.example.madlevel6task2.api

import com.example.madlevel6task2.service.MovieAPIService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MoviesAPI {
    companion object {
        // The base url off the api.
        private const val baseUrl = "https://api.themoviedb.org/3/"

        fun createApi(): MovieAPIService{
            // Create an OkHttpClient to be able to make a log of the network traffic
            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build()

            // Create the Retrofit instance
            val moviesAPI = Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            // Return the Retrofit MovieAPIService
            return moviesAPI.create(MovieAPIService::class.java)
        }
    }
}