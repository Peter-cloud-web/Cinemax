package com.example.paging.pagingSource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.entities.model.tvShowsResponse.TvShowsResults
import com.example.domain.repository.MovieRepository
import retrofit2.HttpException
import javax.inject.Inject

class TvShowsOnTheAirPagingSource @Inject constructor(
    private val repository: MovieRepository
) : PagingSource<Int, TvShowsResults>() {
    override fun getRefreshKey(state: PagingState<Int, TvShowsResults>): Int? {
        return 1
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, TvShowsResults> {
        return try {
            val currentPage = params.key ?: 1
            val response = repository.getTvShowsOnTheAir(page = currentPage)
            val responseData =
                mutableListOf<TvShowsResults>()
            response.data?.results?.let { responseData.addAll(it) }

            LoadResult.Page(
                data = responseData,
                prevKey = if (currentPage == 1) null else -1,
                nextKey = currentPage.plus(1)
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        }
    }
}