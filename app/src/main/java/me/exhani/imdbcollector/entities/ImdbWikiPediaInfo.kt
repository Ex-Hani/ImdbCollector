package me.exhani.imdbcollector.entities


import com.google.gson.annotations.SerializedName

data class ImdbWikiPediaInfo(
    @SerializedName("imDbId")
    val imDbId: String, // tt1375666
    @SerializedName("title")
    val title: String, // Inception
    @SerializedName("fullTitle")
    val fullTitle: String, // Inception (2010)
    @SerializedName("type")
    val type: String, // Movie
    @SerializedName("year")
    val year: String, // 2010
    @SerializedName("language")
    val language: String, // en
    @SerializedName("titleInLanguage")
    val titleInLanguage: String, // Inception
    @SerializedName("url")
    val url: String, // https://en.wikipedia.org/wiki/Inception
    @SerializedName("plotShort")
    val plotShort: PlotShort,
    @SerializedName("plotFull")
    val plotFull: PlotFull,
    @SerializedName("errorMessage")
    val errorMessage: String
)