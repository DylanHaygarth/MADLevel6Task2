package com.example.madlevel6task2.model

import com.google.gson.annotations.SerializedName

data class Movie (
    @SerializedName("popularity") val popularity : Double,
    @SerializedName("vote_count") val voteCount : Int,
    @SerializedName("video") val video : Boolean,
    @SerializedName("poster_path") val posterPath : String,
    @SerializedName("id") val id : Int,
    @SerializedName("adult") val adult : Boolean,
    @SerializedName("backdrop_path") val backdropPath : String,
    @SerializedName("original_language") val originalLanguage : String,
    @SerializedName("original_title") val originalTitle : String,
    @SerializedName("genre_ids") val genreIDs : List<Int>,
    @SerializedName("title") val title : String,
    @SerializedName("vote_average") val rating : Double,
    @SerializedName("overview") val overview : String,
    @SerializedName("release_date") val releaseDate : String
) {
    fun getPosterURL() = "https://image.tmdb.org/t/p/w500${posterPath}"
    fun getBackDropURL() = "https://image.tmdb.org/t/p/w500${backdropPath}"
}