package com.example.cinemaxv3.ui.fragments

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
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.cinemaxv3.R
import com.example.cinemaxv3.databinding.FragmentMovieBinding
import com.example.cinemaxv3.models.Movie
import com.example.cinemaxv3.ui.adapter.PopularMovieAdapter
import com.example.cinemaxv3.ui.adapter.TopRatedMoviesAdapter
import com.example.cinemaxv3.ui.adapter.UpComingMoviesAdapter
import com.example.cinemaxv3.ui.viewmodels.MovieViewModel
import com.example.cinemaxv3.util.ConnectivityObserver
import com.example.cinemaxv3.util.Constants.IMAGE_BASE_URL
import com.example.cinemaxv3.util.NetworkConnectivityObserver
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MovieFragment : Fragment(R.layout.fragment_movie) {

    private lateinit var popularMovieAdapter: PopularMovieAdapter
    private lateinit var upcomingMovieAdapter: UpComingMoviesAdapter
    private lateinit var topRatedMoviesAdapter: TopRatedMoviesAdapter

    private val networkConnectivityObserver: NetworkConnectivityObserver by lazy {
        NetworkConnectivityObserver(requireContext())
    }

    private val movieViewModel: MovieViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentMovieBinding.bind(view)

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

        initMembers()
        checkNetworkConnectivity(binding)
        setUpViews(binding)
        fetchMovies()
        recyclerViewOnClick()

    }

    private fun initMembers() {
        popularMovieAdapter = PopularMovieAdapter()
        upcomingMovieAdapter = UpComingMoviesAdapter()
        topRatedMoviesAdapter = TopRatedMoviesAdapter()

    }

    private fun checkNetworkConnectivity(binding: FragmentMovieBinding){
        
        lifecycleScope.launch {
            networkConnectivityObserver.observer().collect { status ->
                when (status) {
                    ConnectivityObserver.Status.Available -> displayPopularMovie(binding)
                    else -> {binding.vote.text = "Offline"}
                }
            }
        }
    }

    private fun fetchMovies() {
        viewLifecycleOwner.lifecycleScope.launch {
            movieViewModel.getPopularMovies().collectLatest {
                popularMovieAdapter.submitData(it)
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            movieViewModel.getTopRatedMovies().collectLatest {
                topRatedMoviesAdapter.submitData(it)
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            movieViewModel.getUpComingMovies().collectLatest {
                upcomingMovieAdapter.submitData(it)
            }
        }
    }


    private fun setUpViews(binding: FragmentMovieBinding) {
        binding.popularMoviesRecyclerview.apply {
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
            adapter = popularMovieAdapter
        }
        binding.topRatedMoviesRecyclerview.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        binding.topRatedMoviesRecyclerview.adapter = topRatedMoviesAdapter

        binding.upComingMoviesRecyclerview.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        binding.upComingMoviesRecyclerview.adapter = upcomingMovieAdapter

    }


    private fun recyclerViewOnClick() {
        popularMovieAdapter.setOnItemClickListener {movie ->
            val bundle = createMovieBundle(movie)
            findNavController().navigate(R.id.action_movieFragment_to_movieDetailsFragment, bundle)
        }

        topRatedMoviesAdapter.setOnItemClickListener {
            val bundle = Bundle()
            bundle.putString("image", IMAGE_BASE_URL + it.poster_path)
            bundle.putString("backdrop", IMAGE_BASE_URL + it.backdrop_path)
            bundle.putString("title", it.title)
            bundle.putString("description", it.overview)
            bundle.putDouble("rating", it.vote_average)
            bundle.putInt("id", it.id)
            findNavController().navigate(R.id.action_movieFragment_to_movieDetailsFragment, bundle)
        }

        upcomingMovieAdapter.setOnItemClickListener {
            val bundle = Bundle()
            bundle.putString("image", IMAGE_BASE_URL + it.poster_path)
            bundle.putString("backdrop", IMAGE_BASE_URL + it.backdrop_path)
            bundle.putString("title", it.title)
            bundle.putString("description", it.overview)
            bundle.putDouble("rating", it.vote_average)
            bundle.putInt("id", it.id)
            findNavController().navigate(R.id.action_movieFragment_to_movieDetailsFragment, bundle)
        }
    }

    private fun createMovieBundle(movie: Movie): Bundle {
        val bundle = Bundle()
        bundle.putString("image", IMAGE_BASE_URL + movie.poster_path)
        bundle.putString("backdrop", IMAGE_BASE_URL + movie.backdrop_path)
        bundle.putString("title", movie.title)
        bundle.putString("description", movie.overview)
        bundle.putDouble("rating", movie.vote_average)
        bundle.putInt("id", movie.id)
        return bundle
    }

    private fun displayPopularMovie(binding: FragmentMovieBinding) {
                lifecycleScope.launch {
                    movieViewModel.getPopularlyRatedMovies().observe(viewLifecycleOwner) {
                        for (i in 0 until it.results.size) {
                            if (it.results[i].vote_average!! >= 8) {
                                binding.apply {
                                    Glide.with(binding.popMov).load(IMAGE_BASE_URL + it.results[i].poster_path)
                                        .into(popMov)
                                    vote.text = it.results[i].vote_average.toString()
                                }
                                popularMovieOnclick(it.results[i].id, it.results[i].title, binding)
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


