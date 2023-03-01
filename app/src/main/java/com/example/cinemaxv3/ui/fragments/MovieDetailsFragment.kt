package com.example.cinemaxv3.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import coil.load
import com.bumptech.glide.Glide
import com.example.cinemaxv3.R
import com.example.cinemaxv3.databinding.FragmentMovieDetailsBinding
import com.example.cinemaxv3.databinding.FragmentReviewsBinding
import com.example.cinemaxv3.models.Movie
import com.example.cinemaxv3.ui.adapter.PopularMovieAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.invoke
import java.util.logging.Level.INFO


class MovieDetailsFragment: Fragment(R.layout.fragment_movie_details) {

   private lateinit var popularMovieAdapter: PopularMovieAdapter

   override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
      super.onViewCreated(view, savedInstanceState)
      val binding = FragmentMovieDetailsBinding.bind(view)

      (activity as AppCompatActivity?)!!.supportActionBar!!.hide()

      val image = arguments?.getString("image")
      val backdrop = arguments?.getString("backdrop")
      val title = arguments?.getString("title")
      val description = arguments?.getString("description")
      val rating = arguments?.getDouble("rating")
      val id = arguments?.getInt("id")

      binding.movieImage.load(image)
      binding.movieTitle.text = title
      binding.movieDescription.text = description
      binding.backdropImage.load(backdrop)

      popularMovieAdapter = PopularMovieAdapter()

      if (id != null) {
         reviewClickListener(binding, id)
         Log.i("MovieDetailsFragment", "Movie_ID: ${id.toString()}")
      }

   }

   fun reviewClickListener(binding: FragmentMovieDetailsBinding, id: Int) {

      binding.apply {
         playButton.setOnClickListener {
              val bundle = Bundle().apply {
                 putInt("id", id)
              }
            findNavController().navigate(R.id.action_movieDetailsFragment_to_reviewsFragment,bundle)
         }
      }
   }
}
