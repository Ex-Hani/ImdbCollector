package me.exhani.imdbcollector.presentation.movieList

import me.exhani.imdbcollector.entities.Movie
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle
import moxy.viewstate.strategy.alias.Skip

interface MovieListView : MvpView {
    @AddToEndSingle
    fun setList(list: List<Movie>)

    @Skip
    fun showError(msg: String = "")

    @Skip
    fun toCurrentMovie()
}