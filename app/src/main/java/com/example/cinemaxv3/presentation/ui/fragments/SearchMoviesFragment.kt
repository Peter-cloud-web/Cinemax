package com.example.cinemaxv3.presentation.ui.fragments

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import coil.ImageLoader
import com.example.cinemaxv3.R
import com.example.cinemaxv3.data.remote.mappers.Mappers.toMovie
import com.example.cinemaxv3.databinding.FragmentSearchMoviesBinding
import com.example.cinemaxv3.presentation.ui.adapter.SearchMoviesAdapter
import com.example.cinemaxv3.presentation.ui.viewmodels.searchedMoviesViewModel.SearchedMoviesViewModel
import com.example.cinemaxv3.util.Constants
import kotlinx.coroutines.Job
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SearchMoviesFragment : Fragment(R.layout.fragment_search_movies) {

    private lateinit var searchMoviesAdapter: SearchMoviesAdapter
    private lateinit var searchedMoviesViewModel: SearchedMoviesViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentSearchMoviesBinding.bind(view)
        val imageLoader = ImageLoader(requireContext())

        searchMoviesAdapter = SearchMoviesAdapter(imageLoader)
        searchedMoviesViewModel =
            ViewModelProvider(requireActivity()).get(SearchedMoviesViewModel::class.java)

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
        searchMoviesAdapter.setOnItemClickListener {
            val id = it.id
            val image = Constants.IMAGE_BASE_URL + it.poster_path
            val backdrop = Constants.IMAGE_BASE_URL + it.backdrop_path
            val title = it.title.toString()
            val description = it.overview.toString()
            val rating = it.vote_average.toFloat()

            val action =
                SearchMoviesFragmentDirections.actionSearchMoviesFragmentToMovieDetailsFragment(
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