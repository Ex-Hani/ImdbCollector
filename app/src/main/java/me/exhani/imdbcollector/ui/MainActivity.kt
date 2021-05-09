package me.exhani.imdbcollector.ui

import android.os.Bundle
import android.util.Log
import dagger.hilt.android.AndroidEntryPoint
import me.exhani.imdbcollector.R
import me.exhani.imdbcollector.presentation.main.MainPresenter
import me.exhani.imdbcollector.presentation.main.MainView
import me.exhani.imdbcollector.ui.moveList.MovieListFragment
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter

@AndroidEntryPoint
class MainActivity : MvpAppCompatActivity(), MainView {

    @InjectPresenter
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun setRootScreen() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, MovieListFragment())
            .commit()
    }
}