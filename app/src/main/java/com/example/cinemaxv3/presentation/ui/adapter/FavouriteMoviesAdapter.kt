package com.example.cinemaxv3.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.ImageLoader
import coil.request.ImageRequest
import com.bumptech.glide.Glide
import com.example.cinemaxv3.databinding.ItemSearchBinding
import com.example.cinemaxv3.models.Movie
import com.example.cinemaxv3.domain.model.favourites.FavouriteMovies
import javax.inject.Inject

class FavouriteMoviesAdapter @Inject constructor(private val imageLoader: ImageLoader) : RecyclerView.Adapter<FavouriteMoviesAdapter.FavouriteMoviesViewHolder>() {


    private var onFavouriteMovieOnClickListener:((FavouriteMovies) -> Unit)? = null

    inner class FavouriteMoviesViewHolder(val binding:ItemSearchBinding) : RecyclerView.ViewHolder(binding.root)

    val favouriteMovies = AsyncListDiffer(this, FavouriteMoviesComparator)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FavouriteMoviesViewHolder {
        val binding = ItemSearchBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return FavouriteMoviesViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: FavouriteMoviesViewHolder,
        position: Int
    ) {
        val movieAvatar =  "https://image.tmdb.org/t/p/w500"
        val favourites = favouriteMovies.currentList[position]
        with(holder){
            with(favourites){
                val request = ImageRequest.Builder(holder.itemView.context)
                    .data(movieAvatar + (this?.poster_path ?: null))
                    .target(binding.imageMovies)
                    .build()
                imageLoader.enqueue(request)

                binding.ratingMovie.text = this.vote_average.toString()
                binding.movieTitile.text = this.title.toString()
                binding.aboutMovie.text = this.overview.toString()

                itemView.setOnClickListener{
                    this?.let {
                        onFavouriteMovieOnClickListener?.let{ it1 ->
                            it1(it)
                        }
                    }
                }

            }
        }

    }

    fun setOnItemClickListener(listener:(FavouriteMovies) -> Unit){
        onFavouriteMovieOnClickListener = listener
    }

    override fun getItemCount(): Int {
        return favouriteMovies.currentList.size
    }

    companion object {
        private val FavouriteMoviesComparator = object : DiffUtil.ItemCallback<FavouriteMovies>() {
            override fun areItemsTheSame(oldItem: FavouriteMovies, newItem: FavouriteMovies): Boolean {
                return oldItem.id == newItem.id
            }
            override fun areContentsTheSame(oldItem: FavouriteMovies, newItem: FavouriteMovies): Boolean {
                return oldItem == newItem
            }
        }
    }
}