package me.exhani.imdbcollector.ui.moveList

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import me.exhani.imdbcollector.R
import me.exhani.imdbcollector.databinding.FragmentMovieListBinding
import me.exhani.imdbcollector.entities.Movie
import me.exhani.imdbcollector.presentation.movieList.MovieListPresenter
import me.exhani.imdbcollector.presentation.movieList.MovieListView
import me.exhani.imdbcollector.ui.CurrentMovieFragment
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import javax.inject.Inject

@AndroidEntryPoint
class MovieListFragment : MvpAppCompatFragment(), MovieListView {

    @Inject
    @InjectPresenter
    lateinit var presenter: MovieListPresenter

    lateinit var adapter: MovieAdapter
    lateinit var binding: FragmentMovieListBinding

    @ProvidePresenter
    fun providePresenter(): MovieListPresenter {
        return presenter
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_movie_list, container, false)

        adapter =
            MovieAdapter(
                requireContext(),
                onItemClick = { items: List<Movie>, position: Int ->
                    presenter.onItemClicked(items, position)
                })
        binding.movieListButtonSearch.setOnClickListener {
            presenter.onSearchBtnClicked(binding.movieListEditSearch.text.toString())
        }
        binding.movieListRecyclerview.layoutManager = LinearLayoutManager(requireContext())
        binding.movieListRecyclerview.adapter = adapter
        return binding.root
    }


    override fun setList(list: List<Movie>) {
        adapter.items = list
    }

    override fun showError(msg: String) {
        activity.apply {
            Toast.makeText(
                this,
                if (msg == "") getString(R.string.data_error) else msg,
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun toCurrentMovie() {
        activity?.apply {
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_container, CurrentMovieFragment())
                .commit()
        }
    }
}