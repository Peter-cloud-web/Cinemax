package com.example.cinemaxv3.view.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.ImageLoader
import coil.request.ImageRequest
import com.example.cinemaxv3.databinding.ItemSimilarMoviesBinding
import com.example.cinemaxv3.util.Constants.IMAGE_BASE_URL
import com.example.domain.entities.model.similarMoviesResponse.SimilarMovies
import javax.inject.Inject

class SimilarMoviesAdapter @Inject constructor(private val imageLoader: ImageLoader) :
    RecyclerView.Adapter<SimilarMoviesAdapter.SimilarMoviesViewHolder>() {
    inner class SimilarMoviesViewHolder(val binding: ItemSimilarMoviesBinding) :
        RecyclerView.ViewHolder(binding.root)

    val similarMoviesDifferList = AsyncListDiffer(this, SimilarMoviesComparator)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimilarMoviesViewHolder {
        val binding =
            ItemSimilarMoviesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SimilarMoviesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SimilarMoviesViewHolder, position: Int) {
        val similarMoviesAvatar = IMAGE_BASE_URL
        val movies = similarMoviesDifferList.currentList[position]
        with(holder) {
            with(movies) {
                val request = ImageRequest.Builder(holder.itemView.context)
                    .data(similarMoviesAvatar + (this?.poster_path ?: null))
                    .target(binding.imageSimilarMovies)
                    .build()
                imageLoader.enqueue(request)
            }
        }

    }

    override fun getItemCount(): Int {
        return similarMoviesDifferList.currentList.size
    }

    companion object {
        private val SimilarMoviesComparator = object :
            DiffUtil.ItemCallback<SimilarMovies>() {
            override fun areItemsTheSame(
                oldItem: SimilarMovies,
                newItem: SimilarMovies
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: SimilarMovies,
                newItem: SimilarMovies
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

}