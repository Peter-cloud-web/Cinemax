package com.example.domain.pager
import androidx.paging.PagingData
import com.example.cinemaxv3.models.UpComingMovies
import kotlinx.coroutines.flow.Flow

interface UpComingPagingMovies {
    fun getUpComingMovies(): Flow<PagingData<UpComingMovies>>
}