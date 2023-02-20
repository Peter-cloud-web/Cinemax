package com.example.cinemaxv3.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cinemaxv3.databinding.BannerImagesBinding
import com.example.cinemaxv3.databinding.ItemMoviesBinding
import com.example.cinemaxv3.models.Movie
import com.example.cinemaxv3.models.UpComingMovies

class UpComingMoviesAdapter :PagingDataAdapter<UpComingMovies,UpComingMoviesAdapter.UpComingMovieViewHolder>(MovieModelComparator){
  private var onMovieClickListener:((UpComingMovies)->Unit)? = null

  inner class UpComingMovieViewHolder(val binding:ItemMoviesBinding):
          RecyclerView.ViewHolder(binding.root)

  companion object {
   private val MovieModelComparator = object : DiffUtil.ItemCallback<UpComingMovies>() {
    override fun areItemsTheSame(oldItem: UpComingMovies, newItem: UpComingMovies): Boolean {
     return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: UpComingMovies, newItem: UpComingMovies): Boolean {
     return oldItem == newItem
    }
   }
  }

  override fun onBindViewHolder(holder: UpComingMovieViewHolder, position: Int) {
   val movieModel: UpComingMovies? = getItem(position)
   val IMAGE_BASE = "https://image.tmdb.org/t/p/w500"

   with(holder) {
    with(movieModel) {

     Glide.with(holder.itemView)
      .load(IMAGE_BASE + (this?.poster_path ?: null))
      .into(holder.binding.imageMovies)

     binding.tvTitle.text = this?.title ?: null
     binding.Rating.text = this?.vote_average.toString()

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

  fun setOnItemClickListener(listener: (UpComingMovies) -> Unit) {
   onMovieClickListener = listener
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpComingMovieViewHolder {
   return UpComingMovieViewHolder(ItemMoviesBinding.inflate(LayoutInflater.from(parent.context),parent,false))
  }

 }