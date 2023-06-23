package com.example.cinemaxv3.presentation.ui.fragments

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import coil.ImageLoader
import com.example.cinemaxv3.R
import com.example.cinemaxv3.databinding.FragmentReviewsBinding
import com.example.cinemaxv3.presentation.ui.adapter.MovieReviewsAdapter
import com.example.cinemaxv3.presentation.ui.viewmodels.MovieViewModel
import com.example.cinemaxv3.presentation.ui.viewmodels.movieReviewsViewModel.MovieReviewsViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class ReviewsFragment : Fragment(R.layout.fragment_reviews) {
    private lateinit var movieReviewsViewModel: MovieReviewsViewModel
    private lateinit var reviewAdapter: MovieReviewsAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentReviewsBinding.bind(view)
        val id = arguments?.getInt("movieId")
        val imageLoader = ImageLoader(requireContext())

        val actionbar =  (activity as AppCompatActivity).supportActionBar
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

        movieReviewsViewModel = ViewModelProvider(requireActivity()).get(MovieReviewsViewModel::class.java)
        reviewAdapter = MovieReviewsAdapter(imageLoader)

        try {
            if (id != null) {
                lifecycleScope.launch {
                    movieReviewsViewModel.getReviews(id).collectLatest {
                        reviewAdapter.comparator.submitList(it?.results)
                    }
                }
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