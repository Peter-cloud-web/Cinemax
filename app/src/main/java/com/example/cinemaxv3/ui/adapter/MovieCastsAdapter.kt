package com.example.cinemaxv3.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cinemaxv3.databinding.ItemMoviecrewBinding
import com.example.cinemaxv3.domain.model.movieCasts.Cast

class MovieCastsAdapter : RecyclerView.Adapter<MovieCastsAdapter.MovieCastsViewHolder>() {

    inner class MovieCastsViewHolder(val binding: ItemMoviecrewBinding) :
        RecyclerView.ViewHolder(binding.root)

    val comparator = AsyncListDiffer(this, MovieCastModelComparator)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieCastsViewHolder {
        val binding =
            ItemMoviecrewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieCastsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieCastsViewHolder, position: Int) {
        val CastAvatar = "https://image.tmdb.org/t/p/w500"
        val casts = comparator.currentList[position]
        with(holder) {
            with(casts) {
                Glide.with(holder.itemView)
                    .load(CastAvatar + this.profile_path)
                    .into(holder.binding.profileImage)
                binding.crewname.text = this.name.toString()
                binding.role.text = this.character.toString()
            }
        }
    }

    override fun getItemCount(): Int {
        return comparator.currentList.size
    }

    companion object {
        private val MovieCastModelComparator = object : DiffUtil.ItemCallback<Cast>() {
            override fun areItemsTheSame(oldItem: Cast, newItem: Cast): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Cast, newItem: Cast): Boolean {
                return oldItem == newItem
            }
        }
    }
}