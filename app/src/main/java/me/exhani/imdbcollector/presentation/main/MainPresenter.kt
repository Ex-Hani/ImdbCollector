package me.exhani.imdbcollector.presentation.main

import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class MainPresenter : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.setRootScreen()
    }
}