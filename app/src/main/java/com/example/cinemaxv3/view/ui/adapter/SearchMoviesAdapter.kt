package com.example.cinemaxv3.view.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.ImageLoader
import coil.request.ImageRequest
import com.example.cinemaxv3.databinding.ItemSearchBinding
import com.example.cinemaxv3.models.Movie
import com.example.cinemaxv3.util.Constants.IMAGE_BASE_URL
import javax.inject.Inject

class SearchMoviesAdapter @Inject constructor(private val imageLoader: ImageLoader) :
    RecyclerView.Adapter<SearchMoviesAdapter.SearchMoviesViewHolder>() {

    inner class SearchMoviesViewHolder(val binding: ItemSearchBinding) :
        RecyclerView.ViewHolder(binding.root)

    val searchMovies = AsyncListDiffer(this, SearchMoviesComparator)

    private var onMovieClickListener: ((Movie) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchMoviesViewHolder {
        val binding = ItemSearchBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SearchMoviesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SearchMoviesViewHolder, position: Int) {
        val movieAvatar = IMAGE_BASE_URL
        val movies = searchMovies.currentList[position]
        with(holder) {
            with(movies) {
                val request = ImageRequest.Builder(holder.itemView.context)
                    .data(movieAvatar + (this?.poster_path ?: null))
                    .target(binding.imageMovies)
                    .build()
                imageLoader.enqueue(request)

                binding.ratingMovie.text = this.vote_average.toString()
                binding.movieTitile.text = this.title.toString()
                binding.aboutMovie.text = this.overview.toString()

                itemView.setOnClickListener {
                    onMovieClickListener?.let { it(this) }
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return searchMovies.currentList.size
    }

    fun setOnItemClickListener(listener: (Movie) -> Unit) {
        onMovieClickListener = listener
    }

    companion object {
        private val SearchMoviesComparator = object : DiffUtil.ItemCallback<Movie>() {
            override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem == newItem
            }
        }
    }
}