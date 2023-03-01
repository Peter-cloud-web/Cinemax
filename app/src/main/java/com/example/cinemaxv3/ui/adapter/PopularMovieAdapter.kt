package com.example.cinemaxv3.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.cinemaxv3.databinding.ItemMoviesBinding
import com.example.cinemaxv3.models.Movie
import com.example.cinemaxv3.util.DifferCallback

class PopularMovieAdapter :
    PagingDataAdapter<Movie, PopularMovieAdapter.MyViewHolder>(MovieModelComparator) {
    private var onMovieClickListener: ((Movie) -> Unit)? = null

    inner class MyViewHolder(val binding: ItemMoviesBinding) : ViewHolder(binding.root)
    val comparator = AsyncListDiffer(this, MovieModelComparator)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ItemMoviesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val movieModel: Movie? = getItem(position)
        val IMAGE_BASE = "https://image.tmdb.org/t/p/w500"

        with(holder) {
            with(movieModel) {

                Glide.with(holder.itemView)
                    .load(IMAGE_BASE + (this?.poster_path ?: null))
                    .into(holder.binding.imageMovies)

                binding.tvTitle.text = this?.title ?: null
                binding.Rating.text = this?.vote_average.toString()
                Log.i("POPULAR", "List : ${comparator.currentList.size}")

                itemView.setOnClickListener {
                    this?.let {
                        onMovieClickListener?.let { it1 ->
                            it1(it)
                            Glide.with(holder.itemView)
                                .load(IMAGE_BASE + (this?.backdrop_path ?: null))
                                .into(holder.binding.imageMovies)
                        }
                    }
                }
            }
        }
    }

    fun setOnItemClickListener(listener: (Movie) -> Unit) {
        onMovieClickListener = listener
    }

    companion object {
        private val MovieModelComparator = object : DiffUtil.ItemCallback<Movie>() {
            override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem == newItem
            }
        }
    }
}