package com.example.cinemaxv3.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cinemaxv3.databinding.ItemSimilarMoviesBinding
import com.example.cinemaxv3.domain.model.movieCasts.Cast
import com.example.cinemaxv3.domain.model.similarMoviesResponse.SimilarMovies

class SimilarMoviesAdapter: RecyclerView.Adapter<SimilarMoviesAdapter.SimilarMoviesViewHolder>(){
    inner class SimilarMoviesViewHolder(val binding:ItemSimilarMoviesBinding):RecyclerView.ViewHolder(binding.root)

    val similarMoviesDifferList = AsyncListDiffer(this, SimilarMoviesComparator)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimilarMoviesViewHolder {
        val binding = ItemSimilarMoviesBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return SimilarMoviesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SimilarMoviesViewHolder, position: Int) {
        val similarMoviesAvatar = "https://image.tmdb.org/t/p/w500"
        val movies = similarMoviesDifferList.currentList[position]
        with(holder){
            with(movies){
                Glide.with(holder.itemView)
                    .load(similarMoviesAvatar + this.poster_path)
                    .into(binding.imageSimilarMovies)
                binding.similarMoviesRating.text = this.vote_average.toString()
            }
        }

    }

    override fun getItemCount(): Int {
        return similarMoviesDifferList.currentList.size
    }

    companion object {
        private val SimilarMoviesComparator = object : DiffUtil.ItemCallback<SimilarMovies>() {
            override fun areItemsTheSame(oldItem: SimilarMovies, newItem: SimilarMovies): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: SimilarMovies, newItem: SimilarMovies): Boolean {
                return oldItem == newItem
            }
        }
    }

}