package com.example.domain.pager

import androidx.paging.PagingData
import com.example.cinemaxv3.models.Movie
import kotlinx.coroutines.flow.Flow

interface PopularMoviesPager {
    fun getPopularMovies(): Flow<PagingData<Movie>>
}