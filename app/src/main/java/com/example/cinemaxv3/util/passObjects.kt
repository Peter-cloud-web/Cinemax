package com.example.cinemaxv3.util

import com.example.cinemaxv3.view.ui.fragments.MovieFragmentDirections

sealed class MovieItem {
    abstract val poster_path: String
    abstract val backdrop_path: String
    abstract val title: String
    abstract val overview: String
    abstract val vote_average: Float
    abstract val id: Int
}

data class Movie(
    override val poster_path: String,
    override val backdrop_path: String,
    override val title: String,
    override val overview: String,
    override val vote_average: Float,
    override val id: Int
) : MovieItem()

data class TopRatedMovie(
    override val poster_path: String,
    override val backdrop_path: String,
    override val title: String,
    override val overview: String,
    override val vote_average: Float,
    override val id: Int
) : MovieItem()

data class PopularMovie(
    override val poster_path: String,
    override val backdrop_path: String,
    override val title: String,
    override val overview: String,
    override val vote_average: Float,
    override val id: Int
) : MovieItem()

fun passObject(movie: MovieItem):MovieFragmentDirections.ActionMovieFragmentToMovieDetailsFragment {
    with(movie){
        return MovieFragmentDirections.actionMovieFragmentToMovieDetailsFragment(
            Constants.IMAGE_BASE_URL + poster_path,
            Constants.IMAGE_BASE_URL + backdrop_path,
            title.toString(),
            overview.toString(),
            vote_average.toFloat(),
            id
        )
    }
}

