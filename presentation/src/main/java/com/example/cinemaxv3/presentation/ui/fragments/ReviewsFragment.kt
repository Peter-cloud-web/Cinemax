package com.example.cinemaxv3.presentation.ui.fragments

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import coil.ImageLoader
import com.example.cinemaxv3.R
import com.example.cinemaxv3.databinding.FragmentReviewsBinding
import com.example.cinemaxv3.models.responses.Review
import com.example.cinemaxv3.presentation.ui.adapter.MovieReviewsAdapter
import com.example.cinemaxv3.presentation.ui.viewmodels.movieReviewsViewModel.MovieReviewsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ReviewsFragment : Fragment(R.layout.fragment_reviews) {
    private val movieReviewsViewModel: MovieReviewsViewModel by viewModels()
    private lateinit var reviewAdapter: MovieReviewsAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentReviewsBinding.bind(view)
        val id = arguments?.getInt("movieId")
        val imageLoader = ImageLoader(requireContext())

        val actionbar = (activity as AppCompatActivity).supportActionBar
        actionbar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setBackgroundDrawable(context?.let {
                ContextCompat.getColor(
                    it,
                    R.color.black
                )
            }?.let { ColorDrawable(it) })
            title = "Reviews"
        }

        reviewAdapter = MovieReviewsAdapter(imageLoader)

        if (id != null) {
            movieReviewsViewModel.getReviews(id)
        }
        loadMovieReviews()
        showMovies(binding)
    }

    private fun loadMovieReviews() {
        val reviewsList = mutableListOf<Review>()

        viewLifecycleOwner.lifecycleScope.launch {

            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {

                movieReviewsViewModel.movieReviews.observe(viewLifecycleOwner) { uiState ->

                    when {
                        uiState.isLoading -> {}

                        uiState.isSuccess != null -> {
                            val review = uiState.isSuccess.value
                            Log.d("MOVIE REVIEW","$review")
                            if (review != null) {
                                Log.d("MOVIE REVIEW","${review}")
                                reviewsList.addAll(review)
                                reviewAdapter.comparator.submitList(reviewsList)
                            }
                        }

                    }

                }

            }

        }
    }

    private fun showMovies(binding: FragmentReviewsBinding) {
        binding.recyclerviewReviews.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = reviewAdapter
        }
    }
}