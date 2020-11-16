package com.example.madlevel6task2.model

import com.google.gson.annotations.SerializedName

// extra class has to be created because response body of JSON contains 'results' with movies in this item
data class MovieResponse (
    @SerializedName("results") val results : List<Movie>
)