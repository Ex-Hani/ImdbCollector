package me.exhani.imdbcollector.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import dagger.hilt.android.AndroidEntryPoint
import me.exhani.imdbcollector.R
import me.exhani.imdbcollector.databinding.FragmentCurrentMovieBinding
import me.exhani.imdbcollector.entities.ImdbMostPopularMoviesItem
import me.exhani.imdbcollector.entities.ImdbWikiPediaInfo
import me.exhani.imdbcollector.entities.Movie
import me.exhani.imdbcollector.presentation.currentMovie.CurrentMoviePresenter
import me.exhani.imdbcollector.presentation.currentMovie.CurrentMovieView
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import javax.inject.Inject

@AndroidEntryPoint
class CurrentMovieFragment : MvpAppCompatFragment(), CurrentMovieView {
    @Inject
    @InjectPresenter
    lateinit var presenter: CurrentMoviePresenter
    lateinit var binding: FragmentCurrentMovieBinding

    @ProvidePresenter
    fun providePresenter(): CurrentMoviePresenter {
        return presenter
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_current_movie, container, false)
        return binding.root
    }

    override fun showCurrentMovieData(result: Movie) {
        binding.apply {
            currentMovieRating.text = result.getRating()
            currentMovieTitleMovie.text = result.getTitile()
        }
    }

    override fun showError() {
        activity.apply {
            Toast.makeText(this, "Couldn't get data", Toast.LENGTH_SHORT).show()
        }
    }

    override fun setPilot(result: ImdbWikiPediaInfo) {
        binding.apply {
            currentMovieSinopsis.text = result.plotShort.plainText
        }
    }

    override fun setYear(result: Movie) {
        binding.apply {
            currentMovieYear.text = result.getYear()
            Log.d("HaniTag", result.getYear())
        }
    }

}