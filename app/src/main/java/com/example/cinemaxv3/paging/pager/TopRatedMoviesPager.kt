package com.example.cinemaxv3.paging.pager

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.cinemaxv3.db.MovieDatabase
import com.example.cinemaxv3.paging.mediators.PopularMoviesRemoteMediator
import com.example.cinemaxv3.paging.mediators.TopRatedMoviesMediator
import com.example.cinemaxv3.service.MovieApi
import javax.inject.Inject

class TopRatedMoviesPager @Inject constructor(private val api:MovieApi,private val db:MovieDatabase){

    @OptIn(ExperimentalPagingApi::class)
    val pager = Pager(
        config = PagingConfig(
            pageSize = 20,
            prefetchDistance = 10,
            initialLoadSize = 20,
        ),
        pagingSourceFactory = {
            db.getTopRatedMoviesDao().getTopRatedMovies()
        },
        remoteMediator = TopRatedMoviesMediator(
            api,
            db,
        )
    ).flow

}

