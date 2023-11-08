package com.example.cinemaxv3.view.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.ImageLoader
import coil.request.ImageRequest
import com.example.cinemaxv3.databinding.ItemMoviecrewBinding
import com.example.cinemaxv3.util.Constants.IMAGE_BASE_URL
import com.example.domain.entities.model.movieCasts.Cast
import javax.inject.Inject

class MovieCastsAdapter @Inject constructor(private val imageLoader: ImageLoader) :
    RecyclerView.Adapter<MovieCastsAdapter.MovieCastsViewHolder>() {

    inner class MovieCastsViewHolder(val binding: ItemMoviecrewBinding) :
        RecyclerView.ViewHolder(binding.root)

    val comparator = AsyncListDiffer(this, MovieCastModelComparator)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieCastsViewHolder {
        val binding =
            ItemMoviecrewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieCastsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieCastsViewHolder, position: Int) {
        val castAvatar = IMAGE_BASE_URL
        val casts = comparator.currentList[position]
        with(holder) {
            with(casts) {
                val request = ImageRequest.Builder(holder.itemView.context)
                    .data(castAvatar + (this?.profile_path ?: null))
                    .target(binding.profileImage)
                    .build()
                imageLoader.enqueue(request)

                binding.crewname.text = this.name.toString()
                binding.role.text = this.character.toString()
            }
        }
    }

    override fun getItemCount(): Int {
        return comparator.currentList.size
    }

    companion object {
        private val MovieCastModelComparator =
            object : DiffUtil.ItemCallback<Cast>() {
                override fun areItemsTheSame(
                    oldItem: Cast,
                    newItem: Cast
                ): Boolean {
                    return oldItem.id == newItem.id
                }

                override fun areContentsTheSame(
                    oldItem: Cast,
                    newItem: Cast
                ): Boolean {
                    return oldItem == newItem
                }
            }
    }
}