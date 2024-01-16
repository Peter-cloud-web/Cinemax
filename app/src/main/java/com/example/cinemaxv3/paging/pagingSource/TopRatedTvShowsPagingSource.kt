package com.example.cinemaxv3.paging.pagingSource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.cinemaxv3.models.responses.tvShowsResponse.TvShowsResults
import com.example.cinemaxv3.service.MovieApi
import retrofit2.HttpException
import javax.inject.Inject

class TopRatedTvShowsPagingSource @Inject constructor(private val service: MovieApi) :
    PagingSource<Int, TvShowsResults>() {
    override fun getRefreshKey(state: PagingState<Int, TvShowsResults>): Int? {
     return state.anchorPosition?.let{anchorPosition ->
         state.closestPageToPosition(anchorPosition)?.prevKey
     }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, TvShowsResults> {
        return try {
            val currentPage = params.key ?: 1
            val response = service.getTopRatedTvShows(MovieApi.api_key, currentPage)
            val responseData = mutableListOf<TvShowsResults>()
            responseData.addAll(response.results)

            LoadResult.Page(
                 data  = responseData,
                prevKey = if(currentPage >= 1) currentPage - 1 else null,
                nextKey =  currentPage.plus(1)
            )
        }catch (e:Exception){
            LoadResult.Error(e)
        }catch(e:HttpException){
            LoadResult.Error(e)
        }
    }
}