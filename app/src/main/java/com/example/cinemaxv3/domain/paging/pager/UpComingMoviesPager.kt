package com.example.cinemaxv3.domain.paging.pager

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.cinemaxv3.db.MovieDatabase
import com.example.cinemaxv3.domain.paging.mediators.UpComingMoviesMediator
import com.example.cinemaxv3.domain.repository.MovieRepository
import javax.inject.Inject

class UpComingMoviesPager @Inject constructor(
    private val repository: MovieRepository,
    private val db: MovieDatabase
) {



}