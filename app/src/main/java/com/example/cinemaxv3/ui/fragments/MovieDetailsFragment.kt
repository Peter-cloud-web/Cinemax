package com.example.cinemaxv3.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import coil.load
import com.bumptech.glide.Glide
import com.example.cinemaxv3.R
import com.example.cinemaxv3.databinding.FragmentMovieDetailsBinding


class MovieDetailsFragment : Fragment(R.layout.fragment_movie_details) {

   override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
      super.onViewCreated(view, savedInstanceState)
      val binding = FragmentMovieDetailsBinding.bind(view)

      (activity as AppCompatActivity?)!!.supportActionBar!!.hide()

      val image = arguments?.getString("image")
      val backdrop = arguments?.getString("backdrop")
      val title = arguments?.getString("title")
      val description = arguments?.getString("description")
      val rating = arguments?.getDouble("rating")

      binding.movieImage.load(image)
      binding.movieTitle.text = title
      binding.movieDescription.text = description
      binding.backdropImage.load(backdrop)

   }
}