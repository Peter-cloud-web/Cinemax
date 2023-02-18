package com.example.cinemaxv3.paging.pager

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.cinemaxv3.db.MovieDatabase
import com.example.cinemaxv3.paging.mediators.PopularMoviesRemoteMediator
import com.example.cinemaxv3.service.MovieApi
import javax.inject.Inject

class PopularMoviesPager @Inject constructor(
    private val query: String,
    private val api: MovieApi,
    private val db: MovieDatabase
) {

    val popularMoviesDao = db.getMovieDao()

    @OptIn(ExperimentalPagingApi::class)
    val pager = Pager(
        config = PagingConfig(pageSize = 50),
        remoteMediator = PopularMoviesRemoteMediator(query, api, db)
    ) {
        popularMoviesDao.getPopularMovies()
    }
}