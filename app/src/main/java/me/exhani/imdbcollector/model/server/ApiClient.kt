package me.exhani.imdbcollector.model.server

import me.exhani.imdbcollector.entities.ImdbMostPopularMovies
import me.exhani.imdbcollector.entities.ImdbSearchingMovies
import me.exhani.imdbcollector.entities.ImdbWikiPediaInfo
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiClient {

    @GET("MostPopularMovies/{apiKey}")
    suspend fun getMostPopularMovies(
        @Path("apiKey") apiKey: String = "k_lb15hh44"
    ): ImdbMostPopularMovies

    @GET("SearchMovie/{apiKey}/{movieName}")
    suspend fun searchingMovie(
        @Path("movieName") movieName: String,
        @Path("apiKey") apiKey: String = "k_lb15hh44"
    ): ImdbSearchingMovies

    @GET("Wikipedia/{apiKey}/{imdbId}")
    suspend fun getPilot(
        @Path("imdbId") imdbId:String,
        @Path("apiKey") apiKey: String = "k_lb15hh44"
    ): ImdbWikiPediaInfo
}