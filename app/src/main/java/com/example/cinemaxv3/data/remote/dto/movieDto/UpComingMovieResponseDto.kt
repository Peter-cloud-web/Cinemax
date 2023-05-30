package com.example.cinemaxv3.data.remote.dto.movieDto

import com.example.cinemaxv3.models.UpComingMovies
import com.google.gson.annotations.SerializedName

class UpComingMovieResponseDto (
    @SerializedName("page") val page: Int,
    @SerializedName("results") val movies: List<UpComingMoviesDto>,
    @SerializedName("total_pages") val pages: Int)