package com.example.cinemaxv3.presentation.ui.fragments

import android.annotation.SuppressLint
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.cinemaxv3.R
import com.example.cinemaxv3.databinding.FragmentMovieBinding
import com.example.cinemaxv3.presentation.ui.adapter.PopularMovieAdapter
import com.example.cinemaxv3.presentation.ui.adapter.TopRatedMoviesAdapter
import com.example.cinemaxv3.presentation.ui.adapter.UpComingMoviesAdapter
import com.example.cinemaxv3.presentation.ui.viewmodels.popularMoviesViewModel.PopularMoviesViewModel
import com.example.cinemaxv3.presentation.ui.viewmodels.topRatedMovieViewModel.TopRatedMovieViewModel
import com.example.cinemaxv3.presentation.ui.viewmodels.upComingMoviesViewModel.UpComingMoviesViewModel
import com.example.cinemaxv3.util.ConnectivityObserver
import com.example.cinemaxv3.util.Constants.IMAGE_BASE_URL
import com.example.cinemaxv3.util.NetworkConnectivityObserver
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MovieFragment : Fragment(R.layout.fragment_movie) {

    private lateinit var popularMovieAdapter: PopularMovieAdapter
    private lateinit var topRatedMoviesAdapter: TopRatedMoviesAdapter
    private val args: MovieDetailsFragmentArgs by navArgs()
    private lateinit var upComingMoviesAdapter: UpComingMoviesAdapter

    private val networkConnectivityObserver: NetworkConnectivityObserver by lazy {
        NetworkConnectivityObserver(requireContext())
    }

    private val topRatedMovieViewModel: TopRatedMovieViewModel by viewModels()
    private val popularMoviesViewModel: PopularMoviesViewModel by viewModels()
    private val upComingMoviesViewModel: UpComingMoviesViewModel by viewModels()

    @SuppressLint("SuspiciousIndentation")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentMovieBinding.bind(view)



        initMembers()
        checkNetworkConnectivity(binding)
        setUpViews(binding)
        fetchMovies(binding)
        displayPopularMovie(binding)
        recyclerViewOnClick()


        val actionBar = (activity as AppCompatActivity).supportActionBar
        actionBar?.apply {
            setDisplayHomeAsUpEnabled(false)
            setBackgroundDrawable(context?.let {
                ContextCompat.getColor(
                    it, R.color.black
                )
            }?.let { ColorDrawable(it) })
            title = "Cinemax cinematic"
        }


    }

    private fun initMembers() {
        topRatedMoviesAdapter = TopRatedMoviesAdapter()
        popularMovieAdapter = PopularMovieAdapter()
        upComingMoviesAdapter = UpComingMoviesAdapter()


    }

    private fun checkNetworkConnectivity(binding: FragmentMovieBinding) {

        lifecycleScope.launch {
            networkConnectivityObserver.observer().collect { status ->
                when (status) {
                    ConnectivityObserver.Status.Available -> displayPopularMovie(binding)
                    else -> {
                        binding.vote.text = "Offline"
                    }
                }
            }
        }
    }

    private fun fetchMovies(binding: FragmentMovieBinding) {
        lifecycleScope.launch {
            topRatedMovieViewModel.topRatedMovieUiState.collect { uiState ->
                when {
                    uiState.isLoading -> {}
                    uiState.topRatedMovies != null -> {
                        uiState.topRatedMovies.collect {
                            topRatedMoviesAdapter.submitData(it)
                        }
                    }

                    uiState.error != null -> {
                        Toast.makeText(
                            requireContext(),
                            "An unexpected error occurred",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }

        lifecycleScope.launch {
            popularMoviesViewModel.popularMoviesUiState.collect { uiState ->
                when {
                    uiState.isLoading -> {}
                    uiState.popularMovies != null -> {
                        uiState.popularMovies.collect {
                            popularMovieAdapter.submitData(it)
                        }
                    }

                    uiState.error != null -> {
                        Toast.makeText(
                            requireContext(),
                            "An unexpected error occurred",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }

        lifecycleScope.launch {
            upComingMoviesViewModel.upComingMoviesState.collect { uiState ->
                when {
                    uiState.isLoading -> {}
                    uiState.upComingMovies != null -> {
                        uiState.upComingMovies.collect {
                            upComingMoviesAdapter.submitData(it)
                        }
                    }

                    uiState.error != null -> {
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


    private fun setUpViews(binding: FragmentMovieBinding) {
        binding.topRatedMoviesRecyclerview.apply {
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
            adapter = topRatedMoviesAdapter
        }

        binding.popularMoviesRecyclerview.apply {
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
            adapter = popularMovieAdapter
        }

        binding.upComingMoviesRecyclerview.apply {
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
            adapter = upComingMoviesAdapter
        }
    }

    private fun recyclerViewOnClick() {

        popularMovieAdapter.setOnItemClickListener { movie ->

            movie.apply {
                val id = id
                val image = IMAGE_BASE_URL + poster_path
                val backdrop = IMAGE_BASE_URL + backdrop_path
                val title = title.toString()
                val description = overview.toString()
                val rating = vote_average.toFloat()

                val action = MovieFragmentDirections.actionMovieFragmentToMovieDetailsFragment(
                    image,
                    backdrop,
                    title,
                    description,
                    rating,
                    id
                )
                findNavController().navigate(action)
            }
        }


        topRatedMoviesAdapter.setOnItemClickListener { topRatedMovies ->

            topRatedMovies.apply {
                val id = id
                val image = IMAGE_BASE_URL + poster_path
                val backdrop = IMAGE_BASE_URL + backdrop_path
                val title = title.toString()
                val description = overview.toString()
                val rating = vote_average.toFloat()

                val action = MovieFragmentDirections.actionMovieFragmentToMovieDetailsFragment(
                    image,
                    backdrop,
                    title,
                    description,
                    rating,
                    id
                )
                findNavController().navigate(action)
            }

        }

        upComingMoviesAdapter.setOnItemClickListener { upComingMovies ->

            upComingMovies.apply {

                val id = id
                val image = IMAGE_BASE_URL + poster_path
                val backdrop = IMAGE_BASE_URL + backdrop_path
                val title = title.toString()
                val description = overview.toString()
                val rating = vote_average.toFloat()

                val action = MovieFragmentDirections.actionMovieFragmentToMovieDetailsFragment(
                    image,
                    backdrop,
                    title,
                    description,
                    rating,
                    id
                )
                findNavController().navigate(action)
            }
        }
    }

    private fun displayPopularMovie(binding: FragmentMovieBinding) {
        lifecycleScope.launch {
            val it = popularMoviesViewModel.getTopRatedMovie()
            if (it != null) {
                for (i in 0 until it.size) {
                    if (it?.get(i)?.vote_average!! >= 8) {
                        binding.apply {
                            Glide.with(binding.popMov)
                                .load(IMAGE_BASE_URL + it[i].poster_path)
                                .into(popMov)
                            vote.text = it[i].vote_average.toString()
                        }
                        popularMovieOnclick(it[i].id, it[i].title, binding)
                    }
                }
            }
        }
    }


    private fun popularMovieOnclick(id: Int, name: String?, binding: FragmentMovieBinding) {
        binding.btnTrailer.setOnClickListener {
            val bundle = Bundle()
            bundle.putInt("movieId", id)
            bundle.putString("title", name)
            findNavController().navigate(R.id.action_movieFragment_to_trailersFragment, bundle)
        }
    }

}




