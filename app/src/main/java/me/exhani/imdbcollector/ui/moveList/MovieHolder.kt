package me.exhani.imdbcollector.ui.moveList

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import me.exhani.imdbcollector.databinding.RecyclerviewMovieItemBinding

open class MovieHolder(
    val binding: RecyclerviewMovieItemBinding
) : RecyclerView.ViewHolder(binding.root),
    View.OnClickListener {

    init {
        binding.rootLayout.setOnClickListener {
            onClick(binding.rootLayout)
        }
    }

    override fun onClick(v: View?) {

    }
}