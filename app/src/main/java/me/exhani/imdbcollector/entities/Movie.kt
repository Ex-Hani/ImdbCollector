package me.exhani.imdbcollector.entities

import androidx.room.Entity

@Entity
interface Movie {
    fun getTitile(): String
    fun getPoster(): String
    fun getRating(): String
    fun getMovieId(): String
    fun getYear(): String
}