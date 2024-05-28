package com.alvarogomez.acapplication.presentation.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.alvarogomez.acapplication.R
import com.alvarogomez.acapplication.domain.model.MovieModel
import com.alvarogomez.acapplication.presentation.utils.DiffUtilCallback

class MovieListAdapter(private var list: List<MovieModel> = listOf(), private val listener: (MovieModel) -> Unit) :
    RecyclerView.Adapter<MovieListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movies, parent, false)
        return MovieListViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: MovieListViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
        holder.itemView.apply {
            setOnClickListener {
                listener(item)
            }
        }
    }

    fun updateList(newList: List<MovieModel>) {
        val diffUtil = DiffUtilCallback(
            list,
            newList,
            { old, new -> old.id == new.id },
            { old, new -> old == new })
        val result = DiffUtil.calculateDiff(diffUtil)
        list = newList
        result.dispatchUpdatesTo(this)
    }
}