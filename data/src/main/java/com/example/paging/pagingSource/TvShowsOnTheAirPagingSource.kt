package com.example.paging.pagingSource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.domain.entities.model.tvShowsResponse.TvShowsResults
import com.example.domain.repository.RemoteMoviesRepository
import retrofit2.HttpException
import javax.inject.Inject

class TvShowsOnTheAirPagingSource @Inject constructor(
    private val repository: RemoteMoviesRepository
) : PagingSource<Int, TvShowsResults>() {
    override fun getRefreshKey(state: PagingState<Int, TvShowsResults>): Int? {
        return if(state.anchorPosition == null) 1 else state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, TvShowsResults> {
        return try {
            val currentPage = params.key ?: 0
            val response = repository.getTvShowsOnTheAir(page = currentPage)
//            val responseData =
//                mutableListOf<TvShowsResults>()
//            response.data?.results?.let { responseData.addAll(it) }

            LoadResult.Page(
                data = response.data?.results!!.toList(),
                prevKey = if (currentPage > 0) currentPage - 1 else null,
                nextKey = currentPage + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        }
    }
}