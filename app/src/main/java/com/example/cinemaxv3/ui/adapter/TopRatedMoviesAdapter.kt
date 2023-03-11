package com.example.cinemaxv3.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cinemaxv3.databinding.ItemMoviesBinding
import com.example.cinemaxv3.models.Movie
import com.example.cinemaxv3.models.TopRatedMovies

class TopRatedMoviesAdapter :
    PagingDataAdapter<TopRatedMovies, TopRatedMoviesAdapter.TopRatedViewHolder>(MovieModelComparator) {
    private var onMovieClickListener: ((TopRatedMovies) -> Unit)? = null

    inner class TopRatedViewHolder(val binding: ItemMoviesBinding) :
        RecyclerView.ViewHolder(binding.root)

    companion object {
        private val MovieModelComparator = object : DiffUtil.ItemCallback<TopRatedMovies>() {
            override fun areItemsTheSame(oldItem: TopRatedMovies, newItem: TopRatedMovies): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: TopRatedMovies, newItem: TopRatedMovies): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onBindViewHolder(holder: TopRatedViewHolder, position: Int) {
        val movieModel: TopRatedMovies? = getItem(position)
        val IMAGE_BASE = "https://image.tmdb.org/t/p/w500"

        with(holder) {
            with(movieModel) {

                Glide.with(holder.itemView)
                    .load(IMAGE_BASE + (this?.poster_path ?: null))
                    .into(holder.binding.imageMovies)
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


    fun setOnItemClickListener(listener: (TopRatedMovies) -> Unit) {
        onMovieClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopRatedViewHolder {
        return TopRatedViewHolder(
            ItemMoviesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }
}