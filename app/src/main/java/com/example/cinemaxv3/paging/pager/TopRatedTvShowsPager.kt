package com.example.cinemaxv3.paging.pager

import androidx.paging.*
import com.example.cinemaxv3.paging.pagingSource.TopRatedTvShowsPagingSource
import com.example.cinemaxv3.service.MovieApi
import javax.inject.Inject

class TopRatedTvShowsPager @Inject constructor(private val api: MovieApi) {

    @OptIn(ExperimentalPagingApi::class)
    val pager = Pager(
        config = PagingConfig(
            pageSize = 20,
            prefetchDistance = 10,
            initialLoadSize = 20,
            enablePlaceholders = false
        ),
        pagingSourceFactory = {
            TopRatedTvShowsPagingSource(service = api)
        },
    ).flow
}