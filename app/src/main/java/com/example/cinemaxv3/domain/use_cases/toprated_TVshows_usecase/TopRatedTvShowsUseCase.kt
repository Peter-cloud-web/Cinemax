package com.example.cinemaxv3.domain.use_cases.toprated_TVshows_usecase

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.cinemaxv3.common.Resource
import com.example.cinemaxv3.db.MovieDatabase
import com.example.cinemaxv3.domain.model.tvShowsResponse.TvShowsResponses
import com.example.cinemaxv3.domain.model.tvShowsResponse.TvShowsResults
import com.example.cinemaxv3.domain.paging.mediators.TopRatedTvShowsMediator
import com.example.cinemaxv3.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class TopRatedTvShowsUseCase @Inject constructor(
    private val repository: MovieRepository,
    private val movieDatabase: MovieDatabase
) {
    @OptIn(ExperimentalPagingApi::class)
    operator fun invoke() = Pager(
            config = PagingConfig(
                pageSize = 20,
                prefetchDistance = 10,
                initialLoadSize = 20,
                maxSize = 100,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                movieDatabase.getTopRatedTvShowsDao().getTopRatedTvShows()
            },
            remoteMediator = TopRatedTvShowsMediator(
                repository, movieDatabase
            )
        ).flow

    }