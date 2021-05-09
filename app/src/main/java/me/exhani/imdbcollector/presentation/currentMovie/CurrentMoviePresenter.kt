package me.exhani.imdbcollector.presentation.currentMovie

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import me.exhani.imdbcollector.model.di.MovieRepository
import me.exhani.imdbcollector.presentation.base.BasePresenter
import moxy.InjectViewState
import moxy.MvpPresenter
import javax.inject.Inject

@InjectViewState
class CurrentMoviePresenter @Inject constructor(
    private val movieRepository: MovieRepository,
) : MvpPresenter<CurrentMovieView>(), CoroutineScope by CoroutineScope(
    Dispatchers.Main
) {
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadCurrentMovieDetails()
        getPilot()
    }

    private fun loadCurrentMovieDetails() {
        launch {
            try {
                val result = movieRepository.currentMovie
                viewState.showCurrentMovieData(result)
            } catch (e: Exception) {
                viewState.showError()
            }
        }
    }

    private fun getPilot() {
        launch {
            try {
                val imdbId = movieRepository.currentMovie.getMovieId()
                val result = movieRepository.getPilot(imdbId)
                viewState.setPilot(result)
                Log.d("HaniTag", result.toString())
            } catch (e: Exception) {
                viewState.showError()
            }
        }
    }
}