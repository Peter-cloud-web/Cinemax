package com.example.cinemaxv3.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cinemaxv3.R
import com.example.cinemaxv3.databinding.FragmentReviewsBinding
import com.example.cinemaxv3.service.MovieApi
import com.example.cinemaxv3.ui.adapter.MovieReviewsAdapter
import com.example.cinemaxv3.ui.adapter.PopularMovieAdapter
import com.example.cinemaxv3.ui.viewmodels.MovieViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class ReviewsFragment: Fragment(R.layout.fragment_reviews) {
    private lateinit var  movieViewModel: MovieViewModel
    private lateinit var reviewAdapter:MovieReviewsAdapter
    private lateinit var popularMovieAdapter: PopularMovieAdapter



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentReviewsBinding.bind(view)
        val id = arguments?.getInt("id")

        movieViewModel = ViewModelProvider(requireActivity()).get(MovieViewModel::class.java)
        reviewAdapter = MovieReviewsAdapter()
        popularMovieAdapter = PopularMovieAdapter()

 try{
     if (id != null) {
         movieViewModel.getReviews(id).observe(viewLifecycleOwner, { reviews ->
             reviewAdapter.comparator.submitList(reviews.results)
             showMovies(binding)
         })
     }
 }catch (e:HttpException){
     Log.e("Cinemax App","API call failed with error code ${e.code()}")
 }catch(e:IOException){
     Log.e("Cinemax App","API call failed with error code " + e)
 }

        showMovies(binding)
    }

    private fun showMovies(binding: FragmentReviewsBinding) {
        binding.recyclerviewReviews.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = reviewAdapter
            Log.i("Review_Fragment","ListReviewsComparator : ${reviewAdapter.comparator.currentList}")
            Toast.makeText(context,"Loading Movies", Toast.LENGTH_LONG).show()
        }
    }
}