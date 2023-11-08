package com.example.cinemaxv3.view.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.ImageLoader
import coil.request.ImageRequest
import com.example.cinemaxv3.databinding.ItemMoviesBinding
import com.example.cinemaxv3.models.Movie
import com.example.cinemaxv3.util.Constants.IMAGE_BASE_URL
import javax.inject.Inject

class PopularMovieAdapter @Inject constructor(private val imageLoader: ImageLoader) :
    PagingDataAdapter<Movie, PopularMovieAdapter.PopularViewHolder>(PopularMovieModelComparator) {
    private var onMovieClickListener: ((Movie) -> Unit)? = null

    inner class PopularViewHolder(val binding: ItemMoviesBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        val binding = ItemMoviesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PopularViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        val movieModel: Movie? = getItem(position)
        val IMAGE_BASE = IMAGE_BASE_URL

        with(holder) {
            with(movieModel) {
                val request = ImageRequest.Builder(holder.itemView.context)
                    .data(IMAGE_BASE + (this?.poster_path ?: null))
                    .target(binding.imageMovies)
                    .build()
                imageLoader.enqueue(request)

                binding.Rating.text = this?.vote_average.toString()

                itemView.setOnClickListener {
                    this?.let {
                        onMovieClickListener?.let { it1 ->
                            it1(it)
                        }
                    }
                }
            }
        }
    }

    fun setOnItemClickListener(listener: (Movie) -> Unit) {
        onMovieClickListener = listener
    }

    companion object {
        private val PopularMovieModelComparator = object : DiffUtil.ItemCallback<Movie>() {
            override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem == newItem
            }
        }
    }
}