package me.exhani.imdbcollector.entities

interface Movie {
    fun getTitile(): String
    fun getPoster(): String
    fun getRating(): String
    fun getMovieId(): String
}