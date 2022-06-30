package com.example.cinemaxv3

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cinemaxv3.databinding.ItemMoviesBinding

class PopularMovieAdapter(private val movieResponse: List<Movie>): RecyclerView.Adapter<PopularMovieAdapter.MyViewHolder>() {
    private lateinit var  onMovieClick: (movie: MovieResponse) -> Unit


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularMovieAdapter.MyViewHolder {
        val binding = ItemMoviesBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PopularMovieAdapter.MyViewHolder, position: Int) {
        val IMAGE_BASE = "https://image.tmdb.org/t/p/w500"
        with(holder){
            with(movieResponse[position]){
                    Glide.with(binding.movieCover)
                        .load(IMAGE_BASE + this.poster_path)
                        .into(binding.movieCover)
                }
            }
        }
    override fun getItemCount(): Int{
           if (movieResponse== null){
               return 0
           }
            return movieResponse.size


    }

    inner class MyViewHolder(val binding:ItemMoviesBinding):RecyclerView.ViewHolder(binding.root){

        init {
            binding.root.setOnClickListener {

            }
        }
//        fun bind(movieResponse: MovieResponse){
//            itemView.setOnClickListener{
//                onMovieClick.invoke(movieResponse)
//            }
//        }
    }

}