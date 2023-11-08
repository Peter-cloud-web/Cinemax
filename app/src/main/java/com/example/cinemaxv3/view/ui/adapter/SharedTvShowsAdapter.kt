package com.example.cinemaxv3.view.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.ImageLoader
import coil.request.ImageRequest
import com.example.cinemaxv3.databinding.ItemTvShowsBinding
import com.example.cinemaxv3.util.Constants.IMAGE_BASE_URL
import com.example.domain.entities.model.tvShowsResponse.TvShowsResults
import javax.inject.Inject

class SharedTvShowsAdapter @Inject constructor(private val imageLoader: ImageLoader) :
    PagingDataAdapter<TvShowsResults, SharedTvShowsAdapter.TopRatedTvShowsViewHolder>(
        MovieModelComparator
    ) {

    private var onMovieClickListener: ((TvShowsResults) -> Unit)? =
        null

    inner class TopRatedTvShowsViewHolder(val binding: ItemTvShowsBinding) :
        RecyclerView.ViewHolder(binding.root)

    companion object {
        private val MovieModelComparator = object :
            DiffUtil.ItemCallback<TvShowsResults>() {
            override fun areItemsTheSame(
                oldItem: TvShowsResults,
                newItem: TvShowsResults
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: TvShowsResults,
                newItem: TvShowsResults
            ): Boolean {
                return oldItem == newItem
            }
        }

    }

    override fun onBindViewHolder(holder: TopRatedTvShowsViewHolder, position: Int) {
        val topRatedTvShows: TvShowsResults? =
            getItem(position)
        val IMAGE_BASE = IMAGE_BASE_URL

        with(holder) {
            with(topRatedTvShows) {
                val request = ImageRequest.Builder(holder.itemView.context)
                    .data(IMAGE_BASE + (this?.poster_path ?: null))
                    .target(binding.imageTvShows)
                    .build()
                imageLoader.enqueue(request)

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

    fun setOnClickListener(listener: (TvShowsResults) -> Unit) {
        onMovieClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopRatedTvShowsViewHolder {
        return TopRatedTvShowsViewHolder(
            ItemTvShowsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }


}