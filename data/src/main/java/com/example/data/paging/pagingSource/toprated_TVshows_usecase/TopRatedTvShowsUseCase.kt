package com.example.data.paging.pagingSource.toprated_TVshows_usecase

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.framework.model.tvShowsResponse.TvShowsResults
import com.example.db.MovieDatabase
import com.example.domain.MovieRepository
import com.example.data.paging.mediators.TopRatedTvShowsMediator
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TopRatedTvShowsUseCase @Inject constructor(
    private val repository: com.example.domain.MovieRepository,
    private val movieDatabase: MovieDatabase
) {

    operator fun invoke(): Flow<PagingData<TvShowsResults>> {
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
                movieDatabase.getTopRatedTvShowsDao().getTopRatedTvShows()
            },
            remoteMediator = TopRatedTvShowsMediator(
                repository, movieDatabase
            )
        ).flow
        return pager
    }

}