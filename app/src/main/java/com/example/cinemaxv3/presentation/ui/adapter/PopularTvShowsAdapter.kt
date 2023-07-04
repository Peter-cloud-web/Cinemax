package com.example.cinemaxv3.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.ImageLoader
import coil.request.ImageRequest
import com.example.cinemaxv3.databinding.ItemTvShowsBinding
import com.example.cinemaxv3.util.Constants.IMAGE_BASE_URL
import com.example.framework.model.tvShowsResponse.TvShowsResults
import javax.inject.Inject

class PopularTvShowsAdapter @Inject constructor(private val imageLoader: ImageLoader) :
    PagingDataAdapter<TvShowsResults, PopularTvShowsAdapter.PopularTvShowsViewHolder>(
        MovieModelComparator
    ) {
    inner class PopularTvShowsViewHolder(val binding: ItemTvShowsBinding) :
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularTvShowsViewHolder {
        return PopularTvShowsViewHolder(
            ItemTvShowsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PopularTvShowsViewHolder, position: Int) {
        val IMAGE_BASE = IMAGE_BASE_URL
        val popularTvShows: TvShowsResults? =
            getItem(position)

        with(holder) {
            with(popularTvShows) {
                val request = ImageRequest.Builder(holder.itemView.context)
                    .data(IMAGE_BASE + (this?.poster_path ?: null))
                    .target(binding.imageTvShows)
                    .build()
                imageLoader.enqueue(request)
            }
        }
    }
}