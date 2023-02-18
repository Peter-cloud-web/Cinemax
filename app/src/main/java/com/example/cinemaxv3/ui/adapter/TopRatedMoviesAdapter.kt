package com.example.cinemaxv3.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cinemaxv3.databinding.ItemMoviesBinding
import com.example.cinemaxv3.models.Movie

class TopRatedMoviesAdapter :
    PagingDataAdapter<Movie, TopRatedMoviesAdapter.TopRatedViewHolder>(MovieModelComparator) {
    private var onMovieClickListener: ((Movie) -> Unit)? = null

    inner class TopRatedViewHolder(val binding: ItemMoviesBinding) :
        RecyclerView.ViewHolder(binding.root)

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

    override fun onBindViewHolder(holder: TopRatedViewHolder, position: Int) {
        val movieModel: Movie? = getItem(position)
        val IMAGE_BASE = "https://image.tmdb.org/t/p/w500"

        with(holder) {
            with(movieModel) {

                Glide.with(holder.itemView)
                    .load(IMAGE_BASE + (this?.poster_path ?: null))
                    .into(holder.binding.imageMovies)

                binding.tvTitle.text = this?.title ?: null
                binding.Rating.text = this?.vote_average.toString()

                itemView.setOnClickListener {
                    this?.let {
                        onMovieClickListener?.let { it1 ->
                            it1(it)
                            Glide.with(holder.itemView)
                                .load(IMAGE_BASE + (this?.backdrop_path ?: null))
                                .into(holder.binding.imageMovies)
                        }
                    }
                }
            }
        }
    }


    fun setOnItemClickListener(listener: (Movie) -> Unit) {
        onMovieClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopRatedViewHolder {
        return TopRatedViewHolder(
            ItemMoviesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }
}