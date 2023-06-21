package com.example.cinemaxv3.domain.paging.pager

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.cinemaxv3.domain.paging.pagingSource.TvShowsOnTheAirPagingSource
import com.example.cinemaxv3.domain.repository.MovieRepository
import javax.inject.Inject

class TvShowsOnTheAirPager @Inject constructor(private val repository: MovieRepository) {

}
