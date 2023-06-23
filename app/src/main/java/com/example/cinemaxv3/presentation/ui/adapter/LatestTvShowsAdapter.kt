package com.example.cinemaxv3.paging.pagingSource

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.ImageLoader
import coil.request.ImageRequest
import com.bumptech.glide.Glide
import com.example.cinemaxv3.databinding.ItemTvShowsBinding
import com.example.cinemaxv3.domain.model.tvShowsResponse.TvShowsResults
import javax.inject.Inject

class LatestTvShowsAdapter @Inject constructor(private val imageLoader: ImageLoader ): PagingDataAdapter<TvShowsResults, LatestTvShowsAdapter.LatestTvShowsViewHolder>(
    MovieModelComparator) {
    inner class LatestTvShowsViewHolder(val binding: ItemTvShowsBinding) :
        RecyclerView.ViewHolder(binding.root)

    companion object {
        private val MovieModelComparator = object : DiffUtil.ItemCallback<TvShowsResults>() {
            override fun areItemsTheSame(oldItem: TvShowsResults, newItem: TvShowsResults): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: TvShowsResults, newItem: TvShowsResults): Boolean {
                return oldItem == newItem
            }
        }

    }

    override fun onBindViewHolder(holder: LatestTvShowsViewHolder, position: Int) {
        val latestTvShows : TvShowsResults? = getItem(position)
        val IMAGE_BASE = "https://image.tmdb.org/t/p/w500"

        with(holder) {
            with(latestTvShows) {
                val request = ImageRequest.Builder(holder.itemView.context)
                    .data(IMAGE_BASE + (this?.poster_path ?: null))
                    .target(binding.imageTvShows)
                    .build()
                imageLoader.enqueue(request)

                binding.tvShowsRating.text = this?.vote_average.toString()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LatestTvShowsViewHolder {
        return LatestTvShowsViewHolder(ItemTvShowsBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }
}