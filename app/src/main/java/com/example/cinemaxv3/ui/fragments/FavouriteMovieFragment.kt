package com.example.cinemaxv3.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cinemaxv3.R
import com.example.cinemaxv3.databinding.FragmentFavouriteMovieBinding
import com.example.cinemaxv3.models.favourites.FavouriteMovies
import com.example.cinemaxv3.ui.adapter.FavouriteMoviesAdapter
import com.example.cinemaxv3.ui.viewmodels.MovieViewModel
import kotlinx.coroutines.launch


class FavouriteMovieFragment : Fragment(R.layout.fragment_favourite_movie) {

     private lateinit var movieViewModel: MovieViewModel
     private lateinit var favouriteMoviesAdapter: FavouriteMoviesAdapter
     override fun onViewCreated(view:View,savedInstanceState:Bundle?){
          super.onViewCreated(view, savedInstanceState)

          val binding  = FragmentFavouriteMovieBinding.bind(view)

          favouriteMoviesAdapter = FavouriteMoviesAdapter()
          movieViewModel = ViewModelProvider(requireActivity()).get(MovieViewModel::class.java)

          viewLifecycleOwner.lifecycleScope.launch(){
               movieViewModel.fetchFavouriteMovie().collect{
               favouriteMoviesAdapter.favouriteMovies.submitList(it)
               }
          }
          binding.favRecyclerView.layoutManager = LinearLayoutManager(activity)
          binding.favRecyclerView.adapter = favouriteMoviesAdapter

     }

     }
