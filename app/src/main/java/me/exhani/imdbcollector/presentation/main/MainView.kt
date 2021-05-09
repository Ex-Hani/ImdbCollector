package me.exhani.imdbcollector.presentation.main

import moxy.MvpView
import moxy.viewstate.strategy.alias.Skip

interface MainView:MvpView {
    @Skip
    fun setRootScreen()
}