package com.example.cinemaxv3

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cinemaxv3.databinding.ItemMoviesBinding

class UpComingMoviesAdapter(private val upComingMoviesResponse: MovieResponse):
    RecyclerView.Adapter<UpComingMoviesAdapter.MyMoviesViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UpComingMoviesAdapter.MyMoviesViewHolder {
        val binding = ItemMoviesBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyMoviesViewHolder(binding)
    }

    inner class MyMoviesViewHolder(val binding: ItemMoviesBinding):RecyclerView.ViewHolder(binding.root)

    override fun onBindViewHolder(holder: UpComingMoviesAdapter.MyMoviesViewHolder, position: Int) {
        val IMAGE_BASE = "https://image.tmdb.org/t/p/w500"
        with(holder){
            with(upComingMoviesResponse.movies[position]){
                Glide.with(binding.movieCover)
                    .load(IMAGE_BASE + this.poster_path)
                    .into(binding.movieCover)
            }
        }
    }

    override fun getItemCount(): Int {
        return upComingMoviesResponse.movies.size
    }


}