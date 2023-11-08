package com.example.cinemaxv3.view.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.ImageLoader
import coil.request.ImageRequest
import com.example.cinemaxv3.databinding.ItemMoviesBinding
import com.example.cinemaxv3.models.TopRatedMovies
import com.example.cinemaxv3.util.Constants.IMAGE_BASE_URL
import javax.inject.Inject

class TopRatedMoviesAdapter @Inject constructor(private val imageLoader: ImageLoader) :
    PagingDataAdapter<TopRatedMovies, TopRatedMoviesAdapter.TopRatedViewHolder>(
        TopMovieModelComparator
    ) {
    private var onMovieClickListener: ((TopRatedMovies) -> Unit)? = null

    inner class TopRatedViewHolder(val binding: ItemMoviesBinding) :
        RecyclerView.ViewHolder(binding.root)

    companion object {
        private val TopMovieModelComparator = object : DiffUtil.ItemCallback<TopRatedMovies>() {
            override fun areItemsTheSame(
                oldItem: TopRatedMovies,
                newItem: TopRatedMovies
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: TopRatedMovies,
                newItem: TopRatedMovies
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onBindViewHolder(holder: TopRatedViewHolder, position: Int) {
        val movies: TopRatedMovies? = getItem(position)
        val IMAGE_BASE = IMAGE_BASE_URL

        with(holder) {
            with(movies) {
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

    fun setOnItemClickListener(listener: (TopRatedMovies) -> Unit) {
        onMovieClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopRatedViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemMoviesBinding.inflate(inflater, parent, false)
        return TopRatedViewHolder(binding)
    }
}