package com.example.cinemaxv3.paging.pagingSource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.cinemaxv3.models.responses.tvShowsResponse.TvShowsResults
import com.example.cinemaxv3.service.MovieApi
import retrofit2.HttpException
import javax.inject.Inject

class TvShowsOnTheAirPagingSource @Inject constructor(private val service:MovieApi):PagingSource<Int,TvShowsResults>() {
    override fun getRefreshKey(state: PagingState<Int, TvShowsResults>): Int? {
        return 1
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, TvShowsResults> {
        return try {
            val currentPage = params.key?: 1
            val response = service.getTvShowsOnTheAir(MovieApi.api_key,currentPage)
            val responseData = mutableListOf<TvShowsResults>()
            val data = response.results.isEmpty()
            responseData + data

            LoadResult.Page(
                data = responseData,
                prevKey = if (currentPage==1)null else -1,
                nextKey = currentPage.plus(1)
            )
         }catch(e:Exception){
        LoadResult.Error(e)
    }catch (e: HttpException){
        LoadResult.Error(e)
    }
    }
}