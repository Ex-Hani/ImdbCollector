package me.exhani.imdbcollector.presentation.base

import moxy.MvpPresenter

class BasePresenter: MvpPresenter<BaseView>() {
     val myTag: String = "HaniTag"
}