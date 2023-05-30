package com.example.cinemaxv3.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cinemaxv3.R
import com.example.cinemaxv3.databinding.FragmentFavouriteMovieBinding
import com.example.cinemaxv3.domain.model.favourites.FavouriteMovies
import com.example.cinemaxv3.ui.adapter.FavouriteMoviesAdapter
import com.example.cinemaxv3.ui.viewmodels.MovieViewModel
import kotlinx.coroutines.launch


class FavouriteMovieFragment : Fragment(R.layout.fragment_favourite_movie) {

    private lateinit var movieViewModel: MovieViewModel
    private lateinit var favouriteMoviesAdapter: FavouriteMoviesAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentFavouriteMovieBinding.bind(view)

        favouriteMoviesAdapter = FavouriteMoviesAdapter()
        movieViewModel = ViewModelProvider(requireActivity()).get(MovieViewModel::class.java)

        populateRecyclerView(binding)
        handleClickListener()


    }

    private fun handleClickListener() {

        favouriteMoviesAdapter.setOnItemClickListener {
            val movieId = it.id
            val backdrop = it.backdrop_path
            val description = it.overview
            val title = it.title
            val image = it.poster_path
            val rating = it.vote_average
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

    private fun populateRecyclerView(binding: FragmentFavouriteMovieBinding) {
        viewLifecycleOwner.lifecycleScope.launch() {
            movieViewModel.fetchFavouriteMovie().collect {
                favouriteMoviesAdapter.favouriteMovies.submitList(it)
            }
        }
        binding.apply {
            favRecyclerView.apply {
                layoutManager = LinearLayoutManager(activity)
                adapter = favouriteMoviesAdapter
            }
        }
    }

}
