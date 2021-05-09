package me.exhani.imdbcollector.presentation.movieList

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import me.exhani.imdbcollector.entities.Movie
import me.exhani.imdbcollector.model.di.MovieRepository
import me.exhani.imdbcollector.presentation.base.BasePresenter
import moxy.InjectViewState
import moxy.MvpPresenter
import javax.inject.Inject

@InjectViewState
class MovieListPresenter @Inject constructor(
    private val movieRepository: MovieRepository
) : MvpPresenter<MovieListView>(), CoroutineScope by CoroutineScope(
    Dispatchers.Main
) {

    fun onItemClicked(items: List<Movie>, position: Int) {
        movieRepository.currentMovie = items[position]
        viewState.toCurrentMovie()
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadMostPopularMovieList()
    }

    private fun loadListSearchingMovie(search: String) {
        launch {
            try {
                val result = movieRepository.searchingMovie(search = search)
                if (result.results.isNotEmpty())
                    viewState.setList(result.results)
                else {
                    viewState.showError(result.errorMessage)
                    Log.e("HaniTag", result.toString())
                }
            } catch (e: Exception) {
                Log.e("HaniTag", e.toString())
                viewState.showError()
            }
        }
    }

    private fun loadMostPopularMovieList() {
        launch {
            try {
                val result = movieRepository.getMostPopularMovies()
                if (result.items.isNotEmpty())
                    viewState.setList(result.items)
                else viewState.showError(result.errorMessage)
            } catch (e: Exception) {
                viewState.showError()
            }
        }
    }

    fun onSearchBtnClicked(toString: String) {
        loadListSearchingMovie(toString)
    }

}