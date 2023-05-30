package com.example.cinemaxv3.data.remote.mappers

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import com.example.cinemaxv3.data.remote.dto.movieDto.MovieDto
import com.example.cinemaxv3.data.remote.dto.movieDto.TopRatedMoviesDto
import com.example.cinemaxv3.data.remote.dto.movieDto.UpComingMoviesDto
import com.example.cinemaxv3.models.Movie
import com.example.cinemaxv3.models.TopRatedMovies
import com.example.cinemaxv3.models.UpComingMovies
import com.google.gson.annotations.SerializedName

object Mappers {
    fun MovieDto.toMovie(): Movie {
        return Movie(
            backdrop_path = backdrop_path,
            original_title = original_title,
            overview = overview,
            poster_path = poster_path,
            id = id,
            title = title,
            vote_average = vote_average,
            vote_count = vote_count,
            page = page
        )
    }

    fun TopRatedMoviesDto.toTopRatedMovie():TopRatedMovies{
        return TopRatedMovies(
            backdrop_path = backdrop_path,
            original_title = original_title,
            overview = overview,
            poster_path = poster_path,
            id = id,
            title = title,
            vote_average = vote_average,
            vote_count = vote_count,
            page = page
        )
    }

    fun UpComingMoviesDto.toUpComingMovies():UpComingMovies{
        return UpComingMovies(
            backdrop_path = backdrop_path,
            original_title = original_title,
            overview = overview,
            poster_path = poster_path,
            id = id,
            title = title,
            vote_average = vote_average,
            vote_count = vote_count,
            page = page
        )
    }
}