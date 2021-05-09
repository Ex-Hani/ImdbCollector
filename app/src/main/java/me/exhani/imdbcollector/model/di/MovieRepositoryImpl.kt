package me.exhani.imdbcollector.model.di

import me.exhani.imdbcollector.entities.ImdbMostPopularMovies
import me.exhani.imdbcollector.entities.ImdbSearchingMovies
import me.exhani.imdbcollector.entities.ImdbWikiPediaInfo
import me.exhani.imdbcollector.entities.Movie
import me.exhani.imdbcollector.model.server.ApiClient
import java.lang.Exception
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val apiClient: ApiClient
) : MovieRepository {

    override lateinit var currentMovie: Movie

    override suspend fun getMostPopularMovies(): ImdbMostPopularMovies {
        return apiClient.getMostPopularMovies()
    }

    override suspend fun searchingMovie(search: String): ImdbSearchingMovies {
        return apiClient.searchingMovie(search)
    }

    override suspend fun getPilot(imdbId: String): ImdbWikiPediaInfo {
        return apiClient.getPilot(imdbId = currentMovie.getMovieId())
    }
}