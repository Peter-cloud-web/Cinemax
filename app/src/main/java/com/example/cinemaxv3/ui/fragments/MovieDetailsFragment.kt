package com.example.cinemaxv3.ui.fragments

import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import coil.load
import com.example.cinemaxv3.R
import com.example.cinemaxv3.databinding.FragmentMovieDetailsBinding
import com.example.cinemaxv3.di.AppModule
import com.example.cinemaxv3.models.favourites.FavouriteMovies
import com.example.cinemaxv3.ui.viewmodels.MovieViewModel
import com.google.android.material.snackbar.Snackbar


class MovieDetailsFragment : Fragment(R.layout.fragment_movie_details) {

    private lateinit var movieViewModel: MovieViewModel
    private val args:MovieDetailsFragmentArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentMovieDetailsBinding.bind(view)

        movieViewModel = ViewModelProvider(requireActivity()).get(MovieViewModel::class.java)



        val actionbar =  (activity as AppCompatActivity).supportActionBar
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


        val image = args.image
        val backdrop = args.backdrop
        val title = args.title
        val description = args.description
        val rating = args.rating
        val movieId = args.id

        if (backdrop != null) {
            if (image != null) {
                if (title != null) {
                    if (description != null) {
                        if (rating != null) {
                            if (movieId != null) {
                                saveBookMarks(binding,image,backdrop,title,description,rating,movieId)
                            }
                        }
                    }
                }
            }
        }


        binding.movieImage.load(image)
        binding.movieTitle.text = title
        binding.movieDescription.text = description
        binding.backdropImage.load(backdrop)

        if (movieId != null) {
            reviewClickListener(binding, movieId)
            if (title != null) {
                trailerClickListener(binding, movieId, title, view)
                shareClickListener(binding,movieId,title)
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

    fun trailerClickListener(
        binding: FragmentMovieDetailsBinding,
        movieId: Int,
        title: String,
        view: View
    ) {
        binding.apply {
            btnTrailer.setOnClickListener {
                progress.setVisibility(View.VISIBLE)
                val bundle = Bundle().apply {
                    putInt("movieId", movieId)
                    putString("title", title)
                }
                findNavController().navigate(
                    R.id.action_movieDetailsFragment_to_trailersFragment,
                    bundle
                )
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
        id:Int) {
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
                movieViewModel.saveFavouriteMovie(favouriteMovies)
                view?.let { it1 -> Snackbar.make(it1,"Movie Saved Successfully", Snackbar.LENGTH_SHORT).show() }
            }
        }
    }

    fun shareClickListener(binding: FragmentMovieDetailsBinding,id:Int,title: String){

        binding.shareMovie.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_SUBJECT,getString(R.string.app_name))
                val shareMessage = "Have you seen : " +
                        "${title}?\n" +
                        "Catch it all here:\n" +
                        "https://www.themoviedb.org/movie/ " + "${id}"
                putExtra(Intent.EXTRA_TEXT,shareMessage)
            }
            startActivity(Intent.createChooser(shareIntent, "Select app to share with"))
        }
    }
}

