package com.example.cinemaxv3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.NonNull
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.example.cinemaxv3.databinding.ActivityMovieDetailsBinding
import kotlinx.android.synthetic.main.activity_movie_details.*

const val MOVIE_BACKDROP = "extra_movie_backdrop"
const val MOVIE_POSTER = "extra_movie_poster"
const val MOVIE_TITLE = "extra_movie_title"
const val MOVIE_RATING = "extra_movie_rating"
const val MOVIE_RELEASE_DATE = "extra_movie_release_date"
const val MOVIE_OVERVIEW = "extra_movie_overview"

class MovieDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        val binding = ActivityMovieDetailsBinding.inflate(layoutInflater)

        val extras = intent.extras

        if (extras != null){
            populateDetails(extras,binding)
        }else{
            finish()
        }
    }

    private fun populateDetails(extras: Bundle, binding: ActivityMovieDetailsBinding){
        extras.getString(MOVIE_BACKDROP)?.let { backdropPath ->
            Glide.with(this)
                .load("https://image.tmdb.org/t/p/w1280$backdropPath")
                .transform(CenterCrop())
                .into(binding.movieBackdrop)
        }

        extras.getString(MOVIE_POSTER)?.let { posterPath ->
            Glide.with(this)
                .load("https://image.tmdb.org/t/p/w342$posterPath")
                .transform(CenterCrop())
                .into(binding.moviePoster)
        }

        binding.apply {
            movieTitle.text = extras.getString(MOVIE_TITLE,"")
            movieRating.rating = extras.getFloat(MOVIE_RATING,0f)/2
            movie_release_date.text = extras.getString(MOVIE_RELEASE_DATE,"")
            movieOverview.text = extras.getString(MOVIE_OVERVIEW,"")
        }


    }

}