package com.example.cinemaxv3.view.ui.fragments

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.ImageLoader
import com.example.cinemaxv3.R
import com.example.cinemaxv3.databinding.FragmentTvShowsBinding
import com.example.cinemaxv3.util.Constants.IMAGE_BASE_URL
import com.example.cinemaxv3.view.ui.adapter.SharedTvShowsAdapter
import com.example.cinemaxv3.viewmodels.TopRatedTvShowsViewModel.TopRatedTvShowsViewModel
import com.example.cinemaxv3.viewmodels.popularTvShowViewModel.PopularTvShowViewModel
import com.example.cinemaxv3.viewmodels.tvShowsAiringTodayViewModel.TvShowsAiringTodayViewModel
import com.example.cinemaxv3.viewmodels.tvShowsOnTheAirViewModel.TvShowsOnTheAirViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class TvShowsFragment : Fragment(R.layout.fragment_tv_shows) {
    private lateinit var sharedTvShowsAdapter: SharedTvShowsAdapter
    private lateinit var currentAdapter: RecyclerView.Adapter<*>
    private lateinit var recyclerView: RecyclerView

    private val topRatedTvShowsViewModel: TopRatedTvShowsViewModel by viewModels()
    private val popularTvShowViewModel: PopularTvShowViewModel by viewModels()
    private val tvShowsAiringTodayViewModel: TvShowsAiringTodayViewModel by viewModels()
    private val tvShowsOnTheAirViewModel: TvShowsOnTheAirViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentTvShowsBinding.bind(view)
        val imageLoader = ImageLoader(requireContext())
        setHasOptionsMenu(true)

        val actionbar = (activity as AppCompatActivity).supportActionBar
        actionbar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setBackgroundDrawable(context?.let {
                ContextCompat.getColor(
                    it,
                    R.color.black
                )
            }?.let { ColorDrawable(it) })
            title = "Tv Shows"
        }

        initializations(imageLoader)
        loadViewsToRecyclerviews(binding)
        loadDefaultTvShowsBeforeOptions()
        tvShowsInDetail()
        setupMenu()

    }


    private fun initializations(imageLoader: ImageLoader) {
        sharedTvShowsAdapter = SharedTvShowsAdapter(imageLoader = imageLoader)
    }

    private fun loadViewsToRecyclerviews(binding: FragmentTvShowsBinding) {
        binding.topRatedTvShowsMoviesRecyclerview.apply {
            layoutManager = GridLayoutManager(activity, 3)
            adapter = sharedTvShowsAdapter
        }
    }

    private fun loadDefaultTvShowsBeforeOptions() {

        viewLifecycleOwner.lifecycleScope.launch(Dispatchers.IO)
        {
            topRatedTvShowsViewModel.topRatedTvShowsUiState.collect { uiState ->

                withContext(Dispatchers.Main){

                    when {
                        uiState.isLoading -> {}
                        uiState.movies != null -> {
                            uiState.movies.collect {
                                sharedTvShowsAdapter.submitData(it)
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

                currentAdapter = sharedTvShowsAdapter
                recyclerView.adapter = currentAdapter
            }
        }
    }

    private fun tvShowsInDetail() {
        sharedTvShowsAdapter.setOnClickListener { tvShowResults ->

            tvShowResults.apply {
                val movieId = id
                val backdrop = IMAGE_BASE_URL + backdrop_path
                val description = overview
                val title = name
                val image = IMAGE_BASE_URL + poster_path
                val rating = vote_average

                val action = TvShowsFragmentDirections.actionTvShowsFragmentToMovieDetailsFragment(
                    image,
                    backdrop,
                    title,
                    description,
                    rating.toFloat(),
                    movieId
                )
                findNavController().navigate(action)
            }
        }
    }

    private fun setupMenu() {
        (requireActivity() as MenuHost).addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.popup_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                when (menuItem.itemId) {

                    R.id.topRatedTvShows -> {
                        viewLifecycleOwner.lifecycleScope.launch {
                            topRatedTvShowsViewModel.topRatedTvShowsUiState.collect { uiState ->
                                when {
                                    uiState.isLoading -> {
                                        Toast.makeText(
                                            requireContext(),
                                            "We are loading..",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    }

                                    uiState.movies != null -> {
                                        uiState.movies.collect {
                                            sharedTvShowsAdapter.submitData(it)
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
                                currentAdapter = sharedTvShowsAdapter
                                recyclerView.adapter = currentAdapter
                            }
                        }
                        return true
                    }

                    R.id.popularTvShows -> {
                        viewLifecycleOwner.lifecycleScope.launch {
                            popularTvShowViewModel.popularTvShowsUiStates.collect { uiState ->
                                when {
                                    uiState.isLoading -> {}
                                    uiState.movies != null -> {
                                        uiState.movies
                                            .collect {
                                                sharedTvShowsAdapter.submitData(it)
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
                                currentAdapter = sharedTvShowsAdapter
                                recyclerView.adapter = currentAdapter
                            }
                        }
                        return true

                    }

                    R.id.tvShowsOnTheAir -> {
                        viewLifecycleOwner.lifecycleScope.launch {
                            tvShowsOnTheAirViewModel.tvShowsOnTheAir.collect { uiState ->
                                when {
                                    uiState.isLoading -> {}
                                    uiState.movies != null -> {
                                        uiState.movies.collect {
                                            sharedTvShowsAdapter.submitData(it)
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
                                currentAdapter = sharedTvShowsAdapter
                                recyclerView.adapter = currentAdapter
                            }
                        }
                        return true
                    }

                    R.id.tvShowsAiringToday -> {
                        viewLifecycleOwner.lifecycleScope.launch {
                            tvShowsAiringTodayViewModel.tvShowsAiringTodayUiState.collect { uiState ->
                                when {
                                    uiState.isLoading -> {}
                                    uiState.movies != null -> {
                                        uiState.movies.collect {
                                            sharedTvShowsAdapter.submitData(it)
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
                                currentAdapter = sharedTvShowsAdapter
                                recyclerView.adapter = currentAdapter
                            }
                        }
                        return true
                    }

                    android.R.id.home -> {
                        // Handle up button click
                        requireActivity().onBackPressed()

                    }

                }
                return true
            }

        })
    }
}

