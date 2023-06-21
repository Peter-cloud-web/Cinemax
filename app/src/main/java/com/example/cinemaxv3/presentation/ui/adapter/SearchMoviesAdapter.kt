package com.example.cinemaxv3.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cinemaxv3.databinding.ItemSearchBinding
import com.example.cinemaxv3.models.Movie

class SearchMoviesAdapter : RecyclerView.Adapter<SearchMoviesAdapter.SearchMoviesViewHolder>() {

    inner class SearchMoviesViewHolder(val binding:ItemSearchBinding):RecyclerView.ViewHolder(binding.root)

    val searchMovies = AsyncListDiffer(this, SearchMoviesComparator)

    private var onMovieClickListener:((Movie) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchMoviesViewHolder {
        val binding = ItemSearchBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return SearchMoviesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SearchMoviesViewHolder, position: Int) {
        val movieAvatar =  "https://image.tmdb.org/t/p/w500"
        val movies = searchMovies.currentList[position]
        with(holder){
            with(movies){
                Glide.with(holder.itemView)
                    .load(movieAvatar + this.poster_path)
                    .into(binding.imageMovies)
                binding.ratingMovie.text = this.vote_average.toString()
                binding.movieTitile.text = this.title.toString()
                binding.aboutMovie.text = this.overview.toString()

                itemView.setOnClickListener {
                     onMovieClickListener?.let{ it(this) }
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return searchMovies.currentList.size
    }

    fun setOnItemClickListener(listener:(Movie) -> Unit){
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