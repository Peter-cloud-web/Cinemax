package com.example.paging.pagingSource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.domain.entities.model.tvShowsResponse.TvShowsResults
import com.example.domain.repository.RemoteMoviesRepository
import retrofit2.HttpException
import javax.inject.Inject

class PopularTvShowsPagingSource @Inject constructor(
    private val repository: RemoteMoviesRepository
) :
    PagingSource<Int, TvShowsResults>() {
    override fun getRefreshKey(state: PagingState<Int, TvShowsResults>): Int? {
        return if(state.anchorPosition == null) 1 else state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, TvShowsResults> {
        return try {
            val currentPage = params.key ?: 1
            val response = repository.getPopularTvShows(page = currentPage)
            val responseData =
                mutableListOf<TvShowsResults>()
            response.data?.results?.let { TvShowsResponses ->
                responseData.addAll(TvShowsResponses)
            }
            val nextPage = if (responseData.isNotEmpty()) currentPage + 1 else null

            LoadResult.Page(
                data = responseData,
                prevKey = if (currentPage == 1) null else -1,
                nextKey = currentPage + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        }
    }

}