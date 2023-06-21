package com.example.cinemaxv3.domain.paging.pager

import com.example.cinemaxv3.db.MovieDatabase
import com.example.cinemaxv3.domain.repository.MovieRepository
import javax.inject.Inject

class PopularMoviesPager @Inject constructor(
    private val repository: MovieRepository,
    private val db: MovieDatabase,
) {

}