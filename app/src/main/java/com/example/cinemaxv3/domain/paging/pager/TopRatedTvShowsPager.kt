package com.example.cinemaxv3.domain.paging.pager

import androidx.paging.*
import com.example.cinemaxv3.db.MovieDatabase
import com.example.cinemaxv3.domain.paging.mediators.TopRatedTvShowsMediator
import com.example.cinemaxv3.domain.repository.MovieRepository
import javax.inject.Inject

class TopRatedTvShowsPager @Inject constructor(
    private val repository: MovieRepository,
    private val db: MovieDatabase
) {


}