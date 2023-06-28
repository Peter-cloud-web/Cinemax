package com.example.cinemaxv3.presentation.ui.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import coil.ImageLoader
import com.example.cinemaxv3.R
import com.example.cinemaxv3.databinding.FragmentFavouriteMovieBinding
import com.example.cinemaxv3.presentation.ui.adapter.FavouriteMoviesAdapter
import com.example.cinemaxv3.presentation.ui.viewmodels.favouriteMoviesViewModel.FavouriteMoviesViewModel
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
        handleClickListener()
    }
    private fun handleClickListener() {

        favouriteMoviesAdapter.setOnItemClickListener { favouriteMovies ->

            favouriteMovies.apply {

                val movieId = id
                val backdrop = backdrop_path
                val description = overview
                val title = title
                val image = poster_path
                val rating = vote_average

                val action =
                    FavouriteMovieFragmentDirections.actionFavouriteMovieFragmentToMovieDetailsFragment(
                        image!!,
                        backdrop!!,
                        title!!,
                        description!!,
                        rating!!,
                        movieId!!
                    )
                findNavController().navigate(action)
            }
        }

    }

    private fun populateRecyclerView(binding: FragmentFavouriteMovieBinding) {
        viewLifecycleOwner.lifecycleScope.launch {
            favouriteMoviesViewModel.favouriteMovies.collectLatest { uiStates ->
                when {
                    uiStates.isLoading -> {}
                    uiStates.favouriteMovies != null -> {
                        uiStates.favouriteMovies.collect {
                            favouriteMoviesAdapter.favouriteMovies.submitList(it)
                        }
                    }

                    uiStates.error != null -> {
                        Toast.makeText(
                            requireContext(),
                            "An unexpected error occurred",
                            Toast.LENGTH_SHORT
                        ).show()
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


