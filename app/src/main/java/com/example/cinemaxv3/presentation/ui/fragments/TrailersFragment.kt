package com.example.cinemaxv3.presentation.ui.fragments

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import coil.ImageLoader
import com.example.cinemaxv3.R
import com.example.cinemaxv3.databinding.FragmentTrailersBinding
import com.example.cinemaxv3.presentation.ui.adapter.MovieCastsAdapter
import com.example.cinemaxv3.presentation.ui.adapter.SimilarMoviesAdapter
import com.example.cinemaxv3.presentation.ui.viewmodels.movieCastViewModel.MovieCastsViewModel
import com.example.cinemaxv3.presentation.ui.viewmodels.movieTrailerViewModel.MovieTrailerViewModel
import com.example.cinemaxv3.presentation.ui.viewmodels.similarMoviesViewModel.SimilarMoviesViewModel
import com.example.framework.model.movieCasts.Cast
import com.example.framework.model.similarMoviesResponse.SimilarMovies
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TrailersFragment : Fragment(R.layout.fragment_trailers) {

    private val movieTrailerViewModel: MovieTrailerViewModel by viewModels()
    private val movieCastsViewModel: MovieCastsViewModel by viewModels()
    private val similarMoviesViewModel: SimilarMoviesViewModel by viewModels()

    private lateinit var videoView: YouTubePlayerView
    private lateinit var castsAdapter: MovieCastsAdapter
    private lateinit var similarMoviesAdapter: SimilarMoviesAdapter
    private val args: TrailersFragmentArgs by navArgs()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentTrailersBinding.bind(view)
        val imageLoader = ImageLoader(requireContext())

        castsAdapter = MovieCastsAdapter(imageLoader)
        similarMoviesAdapter = SimilarMoviesAdapter(imageLoader)
        videoView = binding.videoView

        val actionbar = requireActivity().actionBar
        actionbar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setBackgroundDrawable(context?.let {
                ContextCompat.getColor(
                    it,
                    R.color.black
                )
            }?.let { ColorDrawable(it) })
            title = "Trailers"
        }



        binding.apply {
            progressbar1.setVisibility(View.VISIBLE)
            progressbar2.setVisibility(View.VISIBLE)
        }

        collectArgumentsAndPerformOperations(binding)
        movieCastsRecyclerView(binding)
        similarMoviesRecyclerView(binding)
    }

    private fun collectArgumentsAndPerformOperations(binding: FragmentTrailersBinding) {
        val id = args.movieId
        if (id != null) {
            movieCastsViewModel.movieCasts(id)
            similarMoviesViewModel.getSimilarMovies(id)
        }
        val title = args.title
        binding.movieName.text = title

        loadMovieCasts()
        loadSimilarMovies()
        playTrailers(id)
    }

    private fun playTrailers(id: Int) {
        movieTrailerViewModel.getMovieTrailer(id)
            .observe(viewLifecycleOwner, { movieTrailerResponse ->

                videoView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {

                    override fun onReady(youTubePlayer: YouTubePlayer) {

                        super.onReady(youTubePlayer)

                        movieTrailerResponse.data?.apply {

                            for (i in 0..results.size - 1) {

                                if (results[i].name == "Trailer") {

                                    youTubePlayer.loadVideo(videoId = results[i].key.toString(), 0f)

                                } else if (results[i].name == "Behind the Scenes") {

                                    youTubePlayer.loadVideo(videoId = results[i].key.toString(), 0f)
                                }
                                youTubePlayer.loadVideo(videoId = results[i].key.toString(), 0f)
                            }
                        }
                    }
                })
            })
    }

    fun loadMovieCasts() {
        val castList = mutableListOf<Cast>()
        lifecycleScope.launch {
            movieCastsViewModel.movieCastResponse.collectLatest { uiState ->
                when {
                    uiState.isLoading -> {}
                    uiState.movieCasts != null -> {
                        val casts = uiState.movieCasts.cast.asFlow()
                        casts.collect {
                            castList.addAll(listOf(it))
                        }
                        castsAdapter.comparator.submitList(castList)
                    }

                    uiState.error != null -> {
                        Toast.makeText(
                            requireContext(),
                            "An unexpected error occurred, When loading casts",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

            }
        }
    }

    fun movieCastsRecyclerView(binding: FragmentTrailersBinding) {
        binding.recyclerviewMovieCasts.apply {
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
            adapter = castsAdapter
            binding.progressbar1.setVisibility(View.GONE)
        }
    }

    fun loadSimilarMovies() {
        val similarMoviesResults =
            mutableListOf<SimilarMovies>()
        lifecycleScope.launch {
            similarMoviesViewModel.similarMovies.collectLatest { uiState ->
                when {
                    uiState.isLoading -> {}
                    uiState.similarMovies != null -> {
                        val similarMoviesResponse = uiState.similarMovies.results.asFlow()
                        similarMoviesResponse.collect {
                            similarMoviesResults.addAll(listOf(it))
                        }
                        similarMoviesAdapter.similarMoviesDifferList.submitList(similarMoviesResults)
                    }

                    uiState.error != null -> {
                        Toast.makeText(
                            requireContext(),
                            "An unexpected error occurred, When loading similar movies",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }
    }

    fun similarMoviesRecyclerView(binding: FragmentTrailersBinding) {
        binding.recyclerviewSimilar.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerviewSimilar.adapter = similarMoviesAdapter
        binding.progressbar2.setVisibility(View.GONE)
    }
}

