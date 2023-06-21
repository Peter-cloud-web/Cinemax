package com.example.cinemaxv3.paging.pagingSource

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cinemaxv3.databinding.ItemTvShowsBinding
import com.example.cinemaxv3.domain.model.tvShowsResponse.TvShowsResults

class LatestTvShowsAdapter: PagingDataAdapter<TvShowsResults, LatestTvShowsAdapter.LatestTvShowsViewHolder>(
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
                Glide.with(holder.itemView)
                    .load(IMAGE_BASE + (this?.poster_path))
                    .into(binding.imageTvShows)
                binding.tvShowsRating.text = this?.vote_average.toString()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LatestTvShowsViewHolder {
        return LatestTvShowsViewHolder(ItemTvShowsBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }
}