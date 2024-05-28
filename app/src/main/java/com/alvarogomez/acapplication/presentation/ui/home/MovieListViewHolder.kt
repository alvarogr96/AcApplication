package com.alvarogomez.acapplication.presentation.ui.home

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.alvarogomez.acapplication.databinding.ItemMoviesBinding
import com.alvarogomez.acapplication.domain.model.MovieModel
import com.bumptech.glide.Glide

class MovieListViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val binding = ItemMoviesBinding.bind(view)

    fun bind(item: MovieModel) {
        with(binding) {
            Glide.with(cover).load("https://image.tmdb.org/t/p/w500/${item.poster_path}").into(cover)
            tvMovieTitle.text = item.title
        }
    }

}
