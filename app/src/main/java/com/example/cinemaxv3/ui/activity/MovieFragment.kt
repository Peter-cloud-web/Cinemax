package com.example.cinemaxv3.ui.activity

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.cinemaxv3.R
import com.example.cinemaxv3.databinding.FragmentMovieBinding
import com.example.cinemaxv3.ui.adapter.PopularMovieAdapter
import com.example.cinemaxv3.ui.viewmodels.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MovieFragment : Fragment(R.layout.fragment_movie) {
    private lateinit var popularMovieAdapter: PopularMovieAdapter
    private var fragmentMovieBinding: FragmentMovieBinding? = null
    private val movieViewModel:MovieViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentMovieBinding.bind(view)
        fragmentMovieBinding = binding

        initMembers()
        setUpViews(binding)
        fetchMovies()
    }

    private fun initMembers() {
        popularMovieAdapter = PopularMovieAdapter()
    }

    private fun fetchMovies() {
        lifecycleScope.launch {
            movieViewModel.listData.collectLatest {
                popularMovieAdapter.submitData(it)
            }
        }
    }

    private fun setUpViews(binding: FragmentMovieBinding) {
        binding.popularMoviesRecyclerview.layoutManager = GridLayoutManager(activity,3)
        binding.popularMoviesRecyclerview.adapter = popularMovieAdapter
    }
}

