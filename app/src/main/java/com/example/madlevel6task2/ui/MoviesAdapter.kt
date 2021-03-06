package com.example.madlevel6task2.ui

import android.content.Context
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.madlevel6task2.R
import com.example.madlevel6task2.model.Movie
import kotlinx.android.synthetic.main.item_movie.view.*

class MoviesAdapter(private val movies: List<Movie>, private val onClick: (Movie) -> Unit) : RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {
    private lateinit var context: Context

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener { onClick(movies[adapterPosition]) }
        }

        fun bind(movie: Movie) {
            var moviePlacing = adapterPosition + 1
            itemView.tvRanking.text = context.getString(R.string.placing_movie, moviePlacing)


            Glide.with(context).load(movie.getPosterURL()).into(itemView.ivMovie)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context

        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(movies[position])
    }
}