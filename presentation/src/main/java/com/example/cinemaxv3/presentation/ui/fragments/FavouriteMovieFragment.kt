package com.example.cinemaxv3.presentation.ui.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import coil.ImageLoader
import com.example.cinemaxv3.R
import com.example.cinemaxv3.databinding.FragmentFavouriteMovieBinding
import com.example.cinemaxv3.presentation.ui.adapter.FavouriteMoviesAdapter
import com.example.cinemaxv3.presentation.ui.viewmodels.favouriteMoviesViewModel.FavouriteMoviesViewModel
import com.example.cinemaxv3.util.Constants.IMAGE_BASE_URL
import com.example.framework.model.favourites.FavouriteMovies
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FavouriteMovieFragment : Fragment(R.layout.fragment_favourite_movie) {
    private lateinit var favouriteMoviesAdapter: FavouriteMoviesAdapter
    private val favouriteMoviesViewModel: FavouriteMoviesViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentFavouriteMovieBinding.bind(view)

        val imageLoader = ImageLoader(requireContext())
        favouriteMoviesAdapter = FavouriteMoviesAdapter(imageLoader)

        populateRecyclerView(binding)
        handleItemOnClick()
        deleteFavouriteMovie()
    }

    private fun handleItemOnClick() {
        favouriteMoviesAdapter.setOnItemClickListener { favouriteMovies ->
            navigateToDetailsScreen(favouriteMovies)
        }
    }

    private fun navigateToDetailsScreen(favouriteMovies: FavouriteMovies) {
        with(favouriteMovies) {
            val action =
                FavouriteMovieFragmentDirections.actionFavouriteMovieFragmentToMovieDetailsFragment(
                    IMAGE_BASE_URL + poster_path!!,
                    IMAGE_BASE_URL + backdrop_path!!,
                    title!!.toString(),
                    overview!!.toString(),
                    vote_average!!.toFloat(),
                    id!!
                )
            findNavController().navigate(action)
        }
    }

    private fun deleteFavouriteMovie() {
        favouriteMoviesAdapter.setOnDeleteMovieClickListener { id ->
            favouriteMoviesViewModel.deleteFavouriteMovie(id)
        }
    }

    private fun populateRecyclerView(binding: FragmentFavouriteMovieBinding) {
        viewLifecycleOwner.lifecycleScope.launch {
            favouriteMoviesViewModel.favouriteMovies.collectLatest { uiStates ->

                with(uiStates) {

                    when {
                        isLoading -> {}

                        favouriteMovies != null -> {
                            uiStates.favouriteMovies.collect { favouriteMoviesList ->
                                favouriteMoviesAdapter.favouriteMovies.submitList(
                                    favouriteMoviesList
                                )
                            }
                        }

                        error != null -> {
                            Toast.makeText(
                                requireContext(),
                                "An unexpected error occurred",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }
            }
        }

        binding.favRecyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = favouriteMoviesAdapter
        }

    }
}


