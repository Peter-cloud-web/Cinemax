package com.example.cinemaxv3.view.ui.fragments

import Mappers.toMovie
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import coil.ImageLoader
import com.example.cinemaxv3.R
import com.example.cinemaxv3.databinding.FragmentSearchMoviesBinding
import com.example.cinemaxv3.util.Constants
import com.example.cinemaxv3.util.Constants.IMAGE_BASE_URL
import com.example.cinemaxv3.view.ui.adapter.SearchMoviesAdapter
import com.example.cinemaxv3.viewmodels.searchedMoviesViewModel.SearchedMoviesViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SearchMoviesFragment : Fragment(R.layout.fragment_search_movies) {

    private lateinit var searchMoviesAdapter: SearchMoviesAdapter
    private val searchedMoviesViewModel: SearchedMoviesViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentSearchMoviesBinding.bind(view)
        val imageLoader = ImageLoader(requireContext())

        searchMoviesAdapter = SearchMoviesAdapter(imageLoader)

        val actionbar = (activity as AppCompatActivity).supportActionBar
        actionbar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setBackgroundDrawable(context?.let {
                ContextCompat.getColor(
                    it,
                    R.color.black
                )
            }?.let { ColorDrawable(it) })
            title = "Search"
        }

        var job: Job? = null
        binding.searchView.addTextChangedListener { searchEditText ->
            job?.cancel()
            job = MainScope().launch() {
                delay(Constants.SEARCH_NEWS_TIME_DELAY)
                searchEditText?.let { editText ->
                    if (editText.toString().isNotEmpty()) {
                        searchedMoviesViewModel.searchMovies(editText.toString())
                    }
                }
            }
        }

        searchedMoviesViewModel.SearchResponse.observe(viewLifecycleOwner, Observer {
            searchMoviesAdapter.searchMovies.submitList(it?.results?.map {
                it.toMovie()
            })
        })

        binding.searchRecyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = searchMoviesAdapter
        }
        searchMoviesAdapter.setOnItemClickListener { movie ->

            with(movie) {

                val action =
                    SearchMoviesFragmentDirections.actionSearchMoviesFragmentToMovieDetailsFragment(
                        IMAGE_BASE_URL + poster_path,
                        IMAGE_BASE_URL + backdrop_path,
                        title.toString(),
                        overview.toString(),
                        vote_average.toFloat(),
                        id
                    )
                findNavController().navigate(action)

            }
        }
    }
}