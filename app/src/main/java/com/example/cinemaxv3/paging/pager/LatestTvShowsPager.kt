package com.example.cinemaxv3.paging.pager

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.cinemaxv3.paging.pagingSource.LatestTvShowsPagingSource
import com.example.cinemaxv3.paging.pagingSource.TvShowsAiringTodayPagingSource
import com.example.cinemaxv3.service.MovieApi
import javax.inject.Inject

class LatestTvShowsPager @Inject constructor(private val api: MovieApi) {
    @OptIn(ExperimentalPagingApi::class)
    val pager = Pager(
        config = PagingConfig(
            pageSize = 20,
            prefetchDistance = 10,
            initialLoadSize = 20,
            enablePlaceholders = false
        ),
        pagingSourceFactory = {
            LatestTvShowsPagingSource (service = api)
        },
    ).flow
}
