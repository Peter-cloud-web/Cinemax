package com.example.cinemaxv3.presentation.ui.fragments

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.ImageLoader
import com.example.cinemaxv3.R
import com.example.cinemaxv3.databinding.FragmentTvShowsBinding
import com.example.cinemaxv3.presentation.ui.adapter.PopularTvShowsAdapter
import com.example.cinemaxv3.presentation.ui.adapter.TopRatedTvShowsAdapter
import com.example.cinemaxv3.presentation.ui.viewmodels.TopRatedTvShowsViewModel.TopRatedTvShowsViewModel
import com.example.cinemaxv3.presentation.ui.viewmodels.popularTvShowViewModel.PopularTvShowViewModel
import com.example.cinemaxv3.presentation.ui.viewmodels.tvShowsAiringTodayViewModel.TvShowsAiringTodayViewModel
import com.example.cinemaxv3.presentation.ui.viewmodels.tvShowsOnTheAirViewModel.TvShowsOnTheAirViewModel
import com.example.cinemaxv3.util.Constants.IMAGE_BASE_URL
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class TvShowsFragment : Fragment(R.layout.fragment_tv_shows) {
    private lateinit var topRatedTvShowsAdapter: TopRatedTvShowsAdapter
    private lateinit var popularTvShowsAdapter: PopularTvShowsAdapter

    private lateinit var topRatedTvShowViewModel: TopRatedTvShowsViewModel
    private lateinit var popularTvShowViewModel: PopularTvShowViewModel
    private lateinit var tvShowsAiringTodayViewModel: TvShowsAiringTodayViewModel
    private lateinit var tvShowsOnTheAirViewModel: TvShowsOnTheAirViewModel

    private lateinit var currentAdapter: RecyclerView.Adapter<*>
    private lateinit var recyclerView: RecyclerView

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

        recyclerView = binding.topRatedTvShowsMoviesRecyclerview
        recyclerView.layoutManager = GridLayoutManager(activity, 3)

        topRatedTvShowViewModel =
            ViewModelProvider(requireActivity()).get(TopRatedTvShowsViewModel::class.java)
        popularTvShowViewModel =
            ViewModelProvider(requireActivity()).get(PopularTvShowViewModel::class.java)
        tvShowsAiringTodayViewModel =
            ViewModelProvider(requireActivity()).get(TvShowsAiringTodayViewModel::class.java)
        tvShowsOnTheAirViewModel =
            ViewModelProvider(requireActivity()).get(TvShowsOnTheAirViewModel::class.java)


        topRatedTvShowsAdapter = TopRatedTvShowsAdapter(imageLoader)
        popularTvShowsAdapter = PopularTvShowsAdapter(imageLoader)


        viewLifecycleOwner.lifecycleScope.launch {
            topRatedTvShowViewModel.topRatedTvShowsUiState.collect { uiState ->
                when {
                    uiState.isLoading -> {}
                    uiState.topRatedTvShowsFlow != null -> {
                        uiState.topRatedTvShowsFlow.collect {
                            topRatedTvShowsAdapter.submitData(it)
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
                currentAdapter = topRatedTvShowsAdapter
                recyclerView.adapter = currentAdapter
            }
        }


        topRatedTvShowsAdapter.setOnClickListener { tvShowResults ->

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

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.popup_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {

            R.id.topRatedTvShows -> {
                viewLifecycleOwner.lifecycleScope.launch {
                    topRatedTvShowViewModel.topRatedTvShowsUiState.collect { uiState ->
                        when {
                            uiState.isLoading -> {}
                            uiState.topRatedTvShowsFlow != null -> {
                                uiState.topRatedTvShowsFlow.collect {
                                    topRatedTvShowsAdapter.submitData(it)
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
                        currentAdapter = topRatedTvShowsAdapter
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
                            uiState.popularTvShows != null -> {
                                uiState.popularTvShows.collect {
                                    topRatedTvShowsAdapter.submitData(it)
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
                        currentAdapter = topRatedTvShowsAdapter
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
                            uiState.tvShowsOnTheAir != null -> {
                                uiState.tvShowsOnTheAir.collect {
                                    topRatedTvShowsAdapter.submitData(it)
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
                        currentAdapter = topRatedTvShowsAdapter
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
                             uiState.tvShowsAiringToday != null -> {
                                 uiState.tvShowsAiringToday.collect {
                                     topRatedTvShowsAdapter.submitData(it)
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
                         currentAdapter = topRatedTvShowsAdapter
                         recyclerView.adapter = currentAdapter
                     }
                 }
                return true
            }

            android.R.id.home -> {
                // Handle up button click
                requireActivity().onBackPressed()

            }

            else -> return super.onOptionsItemSelected(item)
        }
        return true

    }
}

