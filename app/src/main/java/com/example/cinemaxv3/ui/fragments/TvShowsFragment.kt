package com.example.cinemaxv3.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.paging.map
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cinemaxv3.R
import com.example.cinemaxv3.databinding.FragmentTvShowsBinding
import com.example.cinemaxv3.models.TopRatedMovies
import com.example.cinemaxv3.paging.pagingSource.LatestTvShowsAdapter
import com.example.cinemaxv3.ui.adapter.PopularTvShowsAdapter
import com.example.cinemaxv3.ui.adapter.TopRatedMoviesAdapter
import com.example.cinemaxv3.ui.adapter.TopRatedTvShowsAdapter
import com.example.cinemaxv3.ui.viewmodels.MovieViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class TvShowsFragment : Fragment(R.layout.fragment_tv_shows) {
    private lateinit var topRatedTvShowsAdapter: TopRatedTvShowsAdapter
    private lateinit var popularTvShowsAdapter: PopularTvShowsAdapter
    private lateinit var latestTvShowsAdapter: LatestTvShowsAdapter
    private lateinit var movieViewModel: MovieViewModel
    private lateinit var topRatedMoviesAdapter: TopRatedMoviesAdapter
    private lateinit var currentAdapter: RecyclerView.Adapter<*>
    private lateinit var recyclerView: RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentTvShowsBinding.bind(view)
        setHasOptionsMenu(true)

        movieViewModel = ViewModelProvider(requireActivity()).get(MovieViewModel::class.java)
        topRatedTvShowsAdapter = TopRatedTvShowsAdapter()
        popularTvShowsAdapter = PopularTvShowsAdapter()
        latestTvShowsAdapter = LatestTvShowsAdapter()
        topRatedMoviesAdapter = TopRatedMoviesAdapter()

        recyclerView = binding.topRatedTvShowsMoviesRecyclerview
        recyclerView.layoutManager = GridLayoutManager(activity, 3)

        currentAdapter = topRatedMoviesAdapter
        recyclerView.adapter = currentAdapter

        viewLifecycleOwner.lifecycleScope.launch {
            movieViewModel.getTopRatedMovies().collectLatest {
                topRatedMoviesAdapter.submitData(it)
            }
        }

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.popup_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.topRatedTvShows -> {
                viewLifecycleOwner.lifecycleScope.launch {
                    movieViewModel.getTopRatedMovies().collectLatest {
                            topRatedMoviesAdapter.submitData(it)
                    }
                }
                currentAdapter = topRatedMoviesAdapter
                recyclerView.adapter = currentAdapter
                return true
            }
            R.id.popularTvShows -> {
                viewLifecycleOwner.lifecycleScope.launch {
                    movieViewModel.getPopularTvShows().collectLatest {
                        popularTvShowsAdapter.submitData(it)
                    }
                }
                currentAdapter = popularTvShowsAdapter
                recyclerView.adapter = currentAdapter
                return true
            }
            R.id.latestTvShows -> {
                viewLifecycleOwner.lifecycleScope.launch {
                    movieViewModel.getLatestTvShows().collectLatest {
                        Log.d("LATEST TV SHOWS", "${it.map { it.name.toString() }}")
                        latestTvShowsAdapter.submitData(it)
                    }
                }
                currentAdapter = latestTvShowsAdapter
                recyclerView.adapter = currentAdapter
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}
