package com.example.cinemaxv3.ui.fragments

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.cinemaxv3.R
import com.example.cinemaxv3.databinding.FragmentTrailersBinding
import com.example.cinemaxv3.databinding.ItemSimilarMoviesBinding
import com.example.cinemaxv3.ui.adapter.MovieCastsAdapter
import com.example.cinemaxv3.ui.adapter.SimilarMoviesAdapter
import com.example.cinemaxv3.ui.viewmodels.MovieViewModel
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import kotlinx.coroutines.launch

class TrailersFragment : Fragment(R.layout.fragment_trailers) {
    private lateinit var movieViewModel: MovieViewModel
    private lateinit var videoView: YouTubePlayerView
    private lateinit var castsAdapter: MovieCastsAdapter
    private lateinit var similarMoviesAdapter:SimilarMoviesAdapter
    private var playbackState = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        movieViewModel = ViewModelProvider(requireActivity()).get(MovieViewModel::class.java)
        castsAdapter = MovieCastsAdapter()
        similarMoviesAdapter = SimilarMoviesAdapter()

        val actionbar =  requireActivity().actionBar
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

        val binding = FragmentTrailersBinding.bind(view)
        binding.progressbar1.setVisibility(View.VISIBLE)
        binding.progressbar2.setVisibility(View.VISIBLE)
        videoView = binding.videoView
        getLifecycle().addObserver(videoView)

        if(savedInstanceState != null){
            playbackState = savedInstanceState.getInt("playbackState",0)
        }

        videoView  = binding.videoView



        val id = arguments?.getInt("movieId")
        val title = arguments?.getString("title")
        Log.d("Trailer", "${title}")
        binding.movieName.text = title


        if (id != null) {
            loadMovieCasts(id)
            loadSimilarMovies(id)
        }
        movieCastsRecyclerView(binding)
        similarMoviesRecyclerView(binding)

        if (id != null) {
            movieViewModel.getMovieTrailer(id).observe(viewLifecycleOwner, {
                videoView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {

                    override fun onReady(youTubePlayer: YouTubePlayer) {

                        super.onReady(youTubePlayer)

                        for (i in 0..it.results.size - 1) {

                            if (it.results[i].name == "Trailer") {

                                youTubePlayer.loadVideo(videoId = it.results[i].key.toString(), 0f)

                            } else if (it.results[i].name == "Behind the Scenes") {

                                youTubePlayer.loadVideo(videoId = it.results[i].key.toString(), 0f)
                            }
                            youTubePlayer.loadVideo(videoId = it.results[i].key.toString(), 0f)
                        }
                    }
                })
            })
        }
        }

    fun loadMovieCasts(id:Int){
            movieViewModel.getCastMembers(id).observe(viewLifecycleOwner){
                castsAdapter.comparator.submitList(it.cast)
            }
        }

    fun movieCastsRecyclerView(binding: FragmentTrailersBinding){
        binding.recyclerviewMovieCasts.apply {
            layoutManager = LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false)
            adapter = castsAdapter
            binding.progressbar1.setVisibility(View.GONE)
        }
    }
    fun loadSimilarMovies(id: Int){
        movieViewModel.getSimilarMovies(id).observe(viewLifecycleOwner){
            similarMoviesAdapter.similarMovies.submitList(it.results)
        }
    }

    fun similarMoviesRecyclerView(binding: FragmentTrailersBinding){
        binding.recyclerviewSimilar.layoutManager = LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false)
            binding.recyclerviewSimilar.adapter = similarMoviesAdapter
            binding.progressbar2.setVisibility(View.GONE)
        }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("Playback",playbackState)
    }
    }

