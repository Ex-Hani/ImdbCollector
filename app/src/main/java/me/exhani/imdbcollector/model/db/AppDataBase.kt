package me.exhani.imdbcollector.model.db

import androidx.room.Database
import androidx.room.RoomDatabase
import me.exhani.imdbcollector.entities.ImdbMostPopularMoviesItem
import me.exhani.imdbcollector.entities.ImdbSearchingMovieResult
import me.exhani.imdbcollector.entities.Movie
import me.exhani.imdbcollector.entities.PlotShort

@Database(
    entities = [
        Movie::class,
        ImdbMostPopularMoviesItem::class,
        PlotShort::class,
        ImdbSearchingMovieResult::class
    ], version = 1, exportSchema = false
)

abstract class AppDataBase: RoomDatabase(){
    abstract fun movieDao(): MovieDao
    abstract fun moviePopularItemDao():MovieMostPopularItem
    abstract fun moviePlotDao(): MoviePlot
    abstract fun movieSearchingResult(): MovieSearchingResult
}
