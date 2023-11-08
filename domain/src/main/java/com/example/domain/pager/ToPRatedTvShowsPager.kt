package com.example.domain.pager

import androidx.paging.PagingData
import com.example.cinemaxv3.models.UpComingMovies
import com.example.domain.entities.model.tvShowsResponse.TvShowsResults
import kotlinx.coroutines.flow.Flow

interface ToPRatedTvShowsPager {
    fun getTopRatedTvShows(): Flow<PagingData<TvShowsResults>>
}