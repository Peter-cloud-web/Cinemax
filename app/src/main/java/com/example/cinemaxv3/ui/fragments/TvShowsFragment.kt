package com.example.cinemaxv3.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cinemaxv3.R
import com.example.cinemaxv3.databinding.FragmentTvShowsBinding
import com.example.cinemaxv3.ui.adapter.TopRatedTvShowsAdapter
import com.example.cinemaxv3.ui.viewmodels.MovieViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class TvShowsFragment : Fragment(R.layout.fragment_tv_shows) {
    private lateinit var topRatedTvShowsAdapter: TopRatedTvShowsAdapter
    private lateinit var movieViewModel: MovieViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentTvShowsBinding.bind(view)


        movieViewModel = ViewModelProvider(requireActivity()).get(MovieViewModel::class.java)
        topRatedTvShowsAdapter = TopRatedTvShowsAdapter()

        fetchTvShows()
        showTvShows(binding)
    }

    fun fetchTvShows() {
        viewLifecycleOwner.lifecycleScope.launch {
            movieViewModel.getTopRatedTvShows().collectLatest {
                Log.i("TvShowsFragment", "${it}")
                topRatedTvShowsAdapter.submitData(it)
            }
        }
    }

    private fun showTvShows(binding: FragmentTvShowsBinding) {
        binding.topRatedTvShowsMoviesRecyclerview.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        binding.topRatedTvShowsMoviesRecyclerview.adapter = topRatedTvShowsAdapter
    }
}
