package com.example.paging.pagingSource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.cinemaxv3.models.UpComingMovies
import com.example.domain.repository.RemoteMoviesRepository
import retrofit2.HttpException
import javax.inject.Inject

class UpComingMoviesPagingSource @Inject constructor(
    private val repository: RemoteMoviesRepository
) : PagingSource<Int, UpComingMovies>() {
    override fun getRefreshKey(state: PagingState<Int, UpComingMovies>): Int? {
        return 1
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UpComingMovies> {
        return try {
            val currentPage = params.key ?: 1
            val response = repository.getUpComingMovies(page = currentPage)
            val responseData = mutableListOf<UpComingMovies>()
            val data = response.data
            responseData + data



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