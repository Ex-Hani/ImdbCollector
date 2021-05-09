package me.exhani.imdbcollector.entities


import com.google.gson.annotations.SerializedName

data class ImdbMostPopularMovies(
    @SerializedName("items")
    val items: List<ImdbMostPopularMoviesItem>,
    @SerializedName("errorMessage")
    val errorMessage: String
)