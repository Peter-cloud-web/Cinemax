package com.example.cinemaxv3.repository

import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.cinemaxv3.models.Movie
import com.example.cinemaxv3.paging.MoviePagingSource
import com.example.cinemaxv3.service.MovieApi
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class Repository @Inject constructor  (private val api: MovieApi) {
    val listData = Pager(PagingConfig(pageSize = 1)){
        MoviePagingSource(api)
    }.flow
}