package com.example.cinemaxv3.view.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.ImageLoader
import coil.request.ImageRequest
import com.example.cinemaxv3.databinding.ItemMoviesBinding
import com.example.cinemaxv3.models.UpComingMovies
import com.example.cinemaxv3.util.Constants.IMAGE_BASE_URL
import javax.inject.Inject

class UpComingMoviesAdapter @Inject constructor(private val imageLoader: ImageLoader) :
    PagingDataAdapter<UpComingMovies, UpComingMoviesAdapter.UpComingMovieViewHolder>(
        MovieModelComparator
    ) {
    private var onMovieClickListener: ((UpComingMovies) -> Unit)? = null

    inner class UpComingMovieViewHolder(val binding: ItemMoviesBinding) :
        RecyclerView.ViewHolder(binding.root)

    companion object {
        private val MovieModelComparator = object : DiffUtil.ItemCallback<UpComingMovies>() {
            override fun areItemsTheSame(
                oldItem: UpComingMovies,
                newItem: UpComingMovies
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: UpComingMovies,
                newItem: UpComingMovies
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onBindViewHolder(holder: UpComingMovieViewHolder, position: Int) {
        val movieModel: UpComingMovies? = getItem(position)
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

    fun setOnItemClickListener(listener: (UpComingMovies) -> Unit) {
        onMovieClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpComingMovieViewHolder {
        return UpComingMovieViewHolder(
            ItemMoviesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

}