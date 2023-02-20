package com.example.cinemaxv3.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cinemaxv3.R
import com.example.cinemaxv3.databinding.FragmentMovieBinding
import com.example.cinemaxv3.ui.adapter.PopularMovieAdapter
import com.example.cinemaxv3.ui.adapter.TopRatedMoviesAdapter
import com.example.cinemaxv3.ui.adapter.UpComingMoviesAdapter
import com.example.cinemaxv3.ui.viewmodels.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MovieFragment : Fragment(R.layout.fragment_movie) {

    private lateinit var popularMovieAdapter: PopularMovieAdapter
    private lateinit var upcomingMovieAdapter: UpComingMoviesAdapter
    private lateinit var topRatedMoviesAdapter: TopRatedMoviesAdapter

    private var fragmentMovieBinding: FragmentMovieBinding? = null
    private val movieViewModel: MovieViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentMovieBinding.bind(view)
        fragmentMovieBinding = binding

        initMembers()
        setUpViews(binding)
        fetchMovies()
        recyclerViewOnClick()
    }

    private fun initMembers() {
        popularMovieAdapter = PopularMovieAdapter()
        upcomingMovieAdapter = UpComingMoviesAdapter()
        topRatedMoviesAdapter = TopRatedMoviesAdapter()

    }

    private fun fetchMovies() {
        lifecycleScope.launch {
            movieViewModel.getPopularMovies().collect() {
                popularMovieAdapter.submitData(it)
            }
        }

        lifecycleScope.launch {
            movieViewModel.getTopRatedMovies().collectLatest {
                topRatedMoviesAdapter.submitData(it)
            }
        }

        lifecycleScope.launch {
            movieViewModel.getUpComingMovies().collect{
                upcomingMovieAdapter.submitData(it)
            }
        }
    }

    private fun setUpViews(binding: FragmentMovieBinding) {
        binding.popularMoviesRecyclerview.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        binding.popularMoviesRecyclerview.adapter = popularMovieAdapter

        binding.topRatedMoviesRecyclerview.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        binding.topRatedMoviesRecyclerview.adapter = topRatedMoviesAdapter

        binding.upComingMoviesRecyclerview.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        binding.upComingMoviesRecyclerview.adapter = upcomingMovieAdapter

    }


    private fun recyclerViewOnClick() {
        popularMovieAdapter.setOnItemClickListener {
            val bundle = Bundle()
            bundle.putString("image", "https://image.tmdb.org/t/p/w500" + it.poster_path)
            bundle.putString("backdrop", "https://image.tmdb.org/t/p/w500" + it.backdrop_path)
            bundle.putString("title", it.title)
            bundle.putString("description", it.overview)
            bundle.putDouble("rating", it.vote_average)
            findNavController().navigate(R.id.action_movieFragment_to_movieDetailsFragment, bundle)
        }

        topRatedMoviesAdapter.setOnItemClickListener {
            val bundle = Bundle()
            bundle.putString("image", "https://image.tmdb.org/t/p/w500" + it.poster_path)
            bundle.putString("backdrop", "https://image.tmdb.org/t/p/w500" + it.backdrop_path)
            bundle.putString("title", it.title)
            bundle.putString("description", it.overview)
            bundle.putDouble("rating", it.vote_average)
            findNavController().navigate(R.id.action_movieFragment_to_movieDetailsFragment, bundle)
        }

        upcomingMovieAdapter.setOnItemClickListener {
            val bundle = Bundle()
            bundle.putString("image", "https://image.tmdb.org/t/p/w500" + it.poster_path)
            bundle.putString("backdrop", "https://image.tmdb.org/t/p/w500" + it.backdrop_path)
            bundle.putString("title", it.title)
            bundle.putString("description", it.overview)
            bundle.putDouble("rating", it.vote_average)
            findNavController().navigate(R.id.action_movieFragment_to_movieDetailsFragment, bundle)
        }
    }
}

