package com.example.cinemaxv3.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.cinemaxv3.models.Movie
import com.example.cinemaxv3.paging.MoviePagingSource
import com.example.cinemaxv3.service.MovieApi
import kotlinx.coroutines.flow.Flow

class Repository(private val service: MovieApi) {

    fun getPopularMovieStreams(): Flow<PagingData<Movie>> {
        return Pager(PagingConfig(20)) {
            MoviePagingSource(service)
        }.flow
    }
}