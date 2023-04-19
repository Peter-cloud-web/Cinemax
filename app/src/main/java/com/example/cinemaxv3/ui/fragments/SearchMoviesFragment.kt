package com.example.cinemaxv3.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.cinemaxv3.R
import com.example.cinemaxv3.databinding.FragmentSearchMoviesBinding
import com.example.cinemaxv3.ui.adapter.SearchMoviesAdapter
import com.example.cinemaxv3.ui.adapter.SimilarMoviesAdapter
import com.example.cinemaxv3.ui.viewmodels.MovieViewModel
import com.example.cinemaxv3.util.Constants
import kotlinx.coroutines.Job
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
class SearchMoviesFragment : Fragment(R.layout.fragment_search_movies) {

    private lateinit var searchMoviesAdapter: SearchMoviesAdapter
    private lateinit var movieViewModel: MovieViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentSearchMoviesBinding.bind(view)

        searchMoviesAdapter = SearchMoviesAdapter()
        movieViewModel = ViewModelProvider(requireActivity()).get(MovieViewModel::class.java)

        var job: Job? = null
        binding.searchView.addTextChangedListener {
            job?.cancel()
            job = MainScope().launch(){
              delay(Constants.SEARCH_NEWS_TIME_DELAY)
              it?.let{
                  if(it.toString().isNotEmpty()){
                      movieViewModel.searchMovies(it.toString())
                  }
              }
            }
        }
            movieViewModel.searchMoviesResponse.observe(viewLifecycleOwner, Observer { response ->
                searchMoviesAdapter.searchMovies.submitList(response.movies)
            })

        binding.searchRecyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = searchMoviesAdapter
        }
        searchMoviesAdapter.setOnItemClickListener {
            val bundle =    Bundle()
            bundle.putString("image", "https://image.tmdb.org/t/p/w500" + it.poster_path)
            bundle.putString("backdrop", "https://image.tmdb.org/t/p/w500" + it.backdrop_path)
            bundle.putString("title", it.title)
            bundle.putString("description", it.overview)
            bundle.putDouble("rating", it.vote_average)
            bundle.putInt("id", it.id)
            findNavController().navigate(R.id.action_searchMoviesFragment_to_movieDetailsFragment,bundle)
        }
    }
}