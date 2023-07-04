package com.example.domain.pager

import com.example.db.MovieDatabase
import com.example.framework.repository.MovieRepository
import javax.inject.Inject

class TopRatedTvShowsPager @Inject constructor(
    private val repository: com.example.framework.repository.MovieRepository,
    private val db: MovieDatabase
) {


}