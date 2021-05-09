package me.exhani.imdbcollector.model.di

import me.exhani.imdbcollector.entities.ImdbMostPopularMovies
import me.exhani.imdbcollector.entities.ImdbSearchingMovies
import me.exhani.imdbcollector.entities.ImdbWikiPediaInfo
import me.exhani.imdbcollector.entities.Movie

interface MovieRepository {
    var currentMovie: Movie
    suspend fun getMostPopularMovies(): ImdbMostPopularMovies
    suspend fun searchingMovie(
        search: String
    ): ImdbSearchingMovies
    suspend fun getPilot(
        imdbId:String
    ): ImdbWikiPediaInfo
}