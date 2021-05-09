package me.exhani.imdbcollector.presentation.currentMovie

import me.exhani.imdbcollector.entities.ImdbMostPopularMoviesItem
import me.exhani.imdbcollector.entities.ImdbWikiPediaInfo
import me.exhani.imdbcollector.entities.Movie
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle
import moxy.viewstate.strategy.alias.Skip

interface CurrentMovieView : MvpView {

    @AddToEndSingle
    fun showCurrentMovieData(result: Movie)

    @Skip
    fun showError()

    @AddToEndSingle
    fun setPilot(result: ImdbWikiPediaInfo)

    @AddToEndSingle
    fun setYear(result: Movie)
}