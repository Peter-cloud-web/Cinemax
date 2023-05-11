package com.example.cinemaxv3.paging.pager

import androidx.paging.*
import com.example.cinemaxv3.db.MovieDatabase
import com.example.cinemaxv3.paging.mediators.TopRatedTvShowsMediator
import com.example.cinemaxv3.paging.pagingSource.TopRatedTvShowsPagingSource
import com.example.cinemaxv3.service.MovieApi
import javax.inject.Inject

class TopRatedTvShowsPager @Inject constructor(
    private val api: MovieApi,
    private val db: MovieDatabase
) {

    @OptIn(ExperimentalPagingApi::class)
    val pager = Pager(
        config = PagingConfig(
            pageSize = 20,
            prefetchDistance = 10,
            initialLoadSize = 20,
            maxSize = 100,
            enablePlaceholders = false
        ),
        pagingSourceFactory = {
            db.getTopRatedTvShowsDao().getTopRatedTvShows()
        },
        remoteMediator = TopRatedTvShowsMediator(
            api, db
        )
    ).flow
}