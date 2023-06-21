package com.example.cinemaxv3.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.DifferCallback
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cinemaxv3.databinding.ItemTvShowsBinding
import com.example.cinemaxv3.domain.model.tvShowsResponse.TvShowsResults

class PopularTvShowsAdapter : PagingDataAdapter<TvShowsResults, PopularTvShowsAdapter.PopularTvShowsViewHolder>(
    MovieModelComparator){
    inner class PopularTvShowsViewHolder(val binding: ItemTvShowsBinding) : RecyclerView.ViewHolder(binding.root)

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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularTvShowsViewHolder {
        return PopularTvShowsViewHolder(ItemTvShowsBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: PopularTvShowsViewHolder, position: Int) {
        val IMAGE_BASE = "https://image.tmdb.org/t/p/w500"
        val popularTvShows:TvShowsResults? =getItem(position)

        with(holder) {
            with(popularTvShows) {
                Glide.with(holder.itemView)
                    .load(IMAGE_BASE + (this?.poster_path))
                    .into(binding.imageTvShows)
                binding.tvShowsRating.text = this?.vote_average.toString()
            }
        }
    }
}