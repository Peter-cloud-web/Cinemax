package com.example.cinemaxv3.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import coil.load
import com.example.cinemaxv3.R
import com.example.cinemaxv3.databinding.FragmentMovieDetailsBinding
import com.example.cinemaxv3.ui.adapter.PopularMovieAdapter


class MovieDetailsFragment : Fragment(R.layout.fragment_movie_details) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentMovieDetailsBinding.bind(view)

        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
        binding.progress.setVisibility(View.GONE)

        val image = arguments?.getString("image")
        val backdrop = arguments?.getString("backdrop")
        val title = arguments?.getString("title")
        val description = arguments?.getString("description")
        val rating = arguments?.getDouble("rating")
        val movieId = arguments?.getInt("id")

        Log.i("MOVIEDETAILSFRAGMENT","${title}")


        binding.movieImage.load(image)
        binding.movieTitle.text = title
        binding.movieDescription.text = description
        binding.backdropImage.load(backdrop)

        if (movieId != null) {
            reviewClickListener(binding, movieId)
            if (title != null) {
                trailerClickListener(binding, movieId, title ,view)
            }
        }
    }

    fun reviewClickListener(binding: FragmentMovieDetailsBinding, movieId: Int) {
        binding.apply {
            playButton.setOnClickListener {
                progress.setVisibility(View.VISIBLE)
                val bundle = Bundle().apply {
                    putInt("movieId", movieId)
                }
                findNavController().navigate(
                    R.id.action_movieDetailsFragment_to_reviewsFragment,
                    bundle
                )
            }
        }
    }

    fun trailerClickListener(binding: FragmentMovieDetailsBinding, movieId: Int,title:String, view: View) {
            binding.apply {
                btnTrailer.setOnClickListener {
                    progress.setVisibility(View.VISIBLE)
                    val bundle = Bundle().apply {
                        putInt("movieId", movieId)
                        putString("title",title)
                    }
                    findNavController().navigate(
                        R.id.action_movieDetailsFragment_to_trailersFragment,
                        bundle
                    )
                }
            }
    }
}



