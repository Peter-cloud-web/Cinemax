package com.example.cinemaxv3.presentation.ui.fragments

import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import coil.load
import com.example.cinemaxv3.R
import com.example.cinemaxv3.databinding.FragmentMovieDetailsBinding
import com.example.cinemaxv3.domain.model.favourites.FavouriteMovies
import com.example.cinemaxv3.presentation.ui.viewmodels.favouriteMoviesViewModel.FavouriteMoviesViewModel
import com.google.android.material.snackbar.Snackbar


class MovieDetailsFragment : Fragment(R.layout.fragment_movie_details) {

    private val args: MovieDetailsFragmentArgs by navArgs()
    private val  favouriteMoviesViewModel: FavouriteMoviesViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentMovieDetailsBinding.bind(view)

        val actionbar = (activity as AppCompatActivity).supportActionBar
        actionbar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setBackgroundDrawable(context?.let {
                ContextCompat.getColor(
                    it,
                    R.color.black
                )
            }?.let { ColorDrawable(it) })
            title = "MovieDetailsFragment"
        }

        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
        binding.progress.setVisibility(View.GONE)

        collectArgumentsAndPerformOperation(binding, view)

    }

    private fun collectArgumentsAndPerformOperation(
        binding: FragmentMovieDetailsBinding,
        view: View
    ) {
        binding.apply {
            args.apply {
                val image = image
                val backdrop = backdrop
                val title = title
                val description = description
                val rating = rating
                val movieId = id

                movieImage.load(image)
                movieTitle.text = title
                movieDescription.text = description
                backdropImage.load(backdrop)
                Log.i("MOVIE DETAILS","${args.backdrop}")

                saveBookMarks(binding, image, backdrop, title, description, rating, movieId)

                reviewClickListener(binding, movieId)

                trailerClickListener(binding, movieId, title, view)

                shareClickListener(binding, movieId, title)
            }
        }
    }

    fun reviewClickListener(binding: FragmentMovieDetailsBinding, movieId: Int) {
        binding.apply {
            binding.playButton.setOnClickListener {
                progress.setVisibility(View.VISIBLE)

                val id = movieId
                val action =
                    MovieDetailsFragmentDirections.actionMovieDetailsFragmentToReviewsFragment(id)
                findNavController().navigate(action)
            }
        }
    }

    fun trailerClickListener(
        binding: FragmentMovieDetailsBinding,
        movieId: Int,
        title: String,
        view: View
    ) {
        binding.apply {
            btnTrailer.setOnClickListener {
                progress.setVisibility(View.VISIBLE)

                val movieId = movieId
                val title = title

                val action =
                    MovieDetailsFragmentDirections.actionMovieDetailsFragmentToTrailersFragment(
                        movieId,
                        title
                    )
                findNavController().navigate(action)
            }
        }
    }

    fun saveBookMarks(
        binding: FragmentMovieDetailsBinding,
        image: String,
        backdrop: String,
        title: String,
        description: String,
        rating: Float,
        id: Int
    ) {
        binding.apply {
            watchlist.setOnClickListener {
                val title = title
                val description = description
                val rating = rating
                val image = image
                val backdrop = backdrop
                val id = id

                val favouriteMovies = FavouriteMovies(
                    title = title,
                    overview = description,
                    vote_average = rating,
                    poster_path = image,
                    backdrop_path = backdrop,
                    id = id
                )
                favouriteMoviesViewModel.saveFavouriteMovies(favouriteMovies)
                view?.let { it1 ->
                    Snackbar.make(
                        it1,
                        "Movie Saved Successfully",
                        Snackbar.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    fun shareClickListener(binding: FragmentMovieDetailsBinding, id: Int, title: String) {

        binding.shareMovie.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_SUBJECT, getString(R.string.app_name))
                val shareMessage = "Have you checked out : " +
                        "${title}?\n" +
                        "Watch it all here:\n" +
                        "https://www.themoviedb.org/movie/ " + "${id}"
                putExtra(Intent.EXTRA_TEXT, shareMessage)
            }
            startActivity(Intent.createChooser(shareIntent, "Select app to share with"))
        }
    }
}

