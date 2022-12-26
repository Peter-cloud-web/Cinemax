package com.example.cinemaxv3.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.cinemaxv3.databinding.ItemMoviesBinding
import com.example.cinemaxv3.models.Movie
import com.example.cinemaxv3.models.MovieResponse

class PopularMovieAdapter :
    PagingDataAdapter<Movie, PopularMovieAdapter.MyViewHolder>(MovieModelComparator) {
    private lateinit var onMovieClick: (movie: MovieResponse) -> Unit

    inner class MyViewHolder(val binding: ItemMoviesBinding) :

        ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ItemMoviesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val movieModel: Movie? = getItem(position)
        val IMAGE_BASE = "https://image.tmdb.org/t/p/w500"

        with(holder) {
            with(movieModel) {
                Glide.with(holder.itemView)
                    .load(IMAGE_BASE + (this?.poster_path ?: null))
                    .into(holder.binding.image)

                binding.tvDescription.text= this?.title ?: null
            }

        }

    }

    companion object {
        private val MovieModelComparator = object : DiffUtil.ItemCallback<Movie>() {
            override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem == newItem
            }
        }
    }
}