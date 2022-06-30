package com.example.cinemaxv3

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cinemaxv3.databinding.ItemMoviesBinding

class TopRatedMovieAdapter(private val topRatedMovies:MovieResponse):
    RecyclerView.Adapter<TopRatedMovieAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemMoviesBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TopRatedMovieAdapter.ViewHolder {
        val binding = ItemMoviesBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TopRatedMovieAdapter.ViewHolder, position: Int) {
        val IMAGE_BASE = "https://image.tmdb.org/t/p/w500"
        with(holder){
            with(topRatedMovies.movies[position]){
                Glide.with(binding.movieCover)
                    .load(IMAGE_BASE + this.poster_path)
                    .into(binding.movieCover)
                }
            }
        }


    override fun getItemCount(): Int {
        return topRatedMovies.movies.size
    }
}

