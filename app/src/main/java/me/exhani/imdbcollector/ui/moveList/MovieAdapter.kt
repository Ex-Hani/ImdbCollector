package me.exhani.imdbcollector.ui.moveList

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import me.exhani.imdbcollector.R
import me.exhani.imdbcollector.databinding.RecyclerviewMovieItemBinding
import me.exhani.imdbcollector.entities.Movie

class MovieAdapter(
    private val context: Context,
    val onItemClick: ((
        items: List<Movie>,
        position: Int
    ) -> Unit)? = null
) : RecyclerView.Adapter<MovieHolder>() {

    lateinit var binding: RecyclerviewMovieItemBinding

    var items: List<Movie> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieHolder {

        binding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.recyclerview_movie_item,
            parent,
            false
        )

        return object :
            MovieHolder(binding) {
            override fun onClick(v: View?) {
                onItemClick?.invoke(items, adapterPosition)
            }
        }
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        (holder).binding.movitItemTitle.text = items.get(position).getTitile()
        (holder).binding.ratingMovieText.text = items?.get(position)?.getRating()
        if (binding.ratingMovieText.text == "") {
            binding.ratingMovieText.text = "?"
        }

        Glide.with(context)
            .load(items.get(position).getPoster())
            .into((holder).binding.posterItem)
    }

    override fun getItemCount(): Int {
        return items?.size ?: 0
    }
}