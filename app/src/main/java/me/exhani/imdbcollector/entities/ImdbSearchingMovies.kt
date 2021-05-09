package me.exhani.imdbcollector.entities


import com.google.gson.annotations.SerializedName

data class ImdbSearchingMovies(
    @SerializedName("searchType")
    val searchType: String, // Movie
    @SerializedName("expression")
    val expression: String, // Steve
    @SerializedName("results")
    val results: List<ImdbSearchingMovieResult>,
    @SerializedName("errorMessage")
    val errorMessage: String
)