package com.example.cinemaxv3.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.room.withTransaction
import com.example.cinemaxv3.BuildConfig
import com.example.cinemaxv3.db.MovieDatabase
import com.example.cinemaxv3.models.Movie
import com.example.cinemaxv3.paging.pagingSource.PopularMoviesPagingSource
import com.example.cinemaxv3.paging.pagingSource.TopRatedMoviesPagingSource
import com.example.cinemaxv3.paging.pagingSource.UpComingMoviesPagingSource
import com.example.cinemaxv3.service.MovieApi
import com.example.cinemaxv3.util.Resource
import com.example.cinemaxv3.util.networkBoundResource
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


class Repository @Inject constructor(
    private val api: MovieApi
) {
    val popularMovieListData = Pager(PagingConfig(pageSize = 1)) {
        PopularMoviesPagingSource(api)
    }.flow

    val upComingMovieListData = Pager(PagingConfig(pageSize = 1)) {
        UpComingMoviesPagingSource(api)
    }.flow

    val topRatedMovieListData = Pager(PagingConfig(pageSize = 1)) {
        TopRatedMoviesPagingSource(api)
    }.flow


}