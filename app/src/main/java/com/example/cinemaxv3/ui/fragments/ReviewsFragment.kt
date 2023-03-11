package com.example.cinemaxv3.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cinemaxv3.R
import com.example.cinemaxv3.databinding.FragmentReviewsBinding
import com.example.cinemaxv3.ui.adapter.MovieReviewsAdapter
import com.example.cinemaxv3.ui.viewmodels.MovieViewModel
import retrofit2.HttpException
import java.io.IOException

class ReviewsFragment : Fragment(R.layout.fragment_reviews) {
    private lateinit var movieViewModel: MovieViewModel
    private lateinit var reviewAdapter: MovieReviewsAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentReviewsBinding.bind(view)
        val id = arguments?.getInt("id")

        movieViewModel = ViewModelProvider(requireActivity()).get(MovieViewModel::class.java)
        reviewAdapter = MovieReviewsAdapter()

        try {
            if (id != null) {
                movieViewModel.getReviews(id).observe(viewLifecycleOwner, { reviews ->
                    reviewAdapter.comparator.submitList(reviews.results)
                    showMovies(binding)
                })
            }
        } catch (e: HttpException) {
            Log.e("Cinemax App", "API call failed with error code ${e.code()}")
        } catch (e: IOException) {
            Log.e("Cinemax App", "API call failed with error code " + e)
        }

        showMovies(binding)
    }

    private fun showMovies(binding: FragmentReviewsBinding) {
        binding.recyclerviewReviews.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = reviewAdapter
        }
    }
}