package com.example.paging.pagingSource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.cinemaxv3.models.TopRatedMovies
import com.example.domain.repository.RemoteMoviesRepository
import retrofit2.HttpException
import javax.inject.Inject

class TopRatedMoviesPagingSource @Inject constructor(
    private val repository: RemoteMoviesRepository
) : PagingSource<Int, TopRatedMovies>() {
    override fun getRefreshKey(state: PagingState<Int, TopRatedMovies>): Int? {
        return 1
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, TopRatedMovies> {
        return try {
            val currentPage = params.key ?: 1
            val response = repository.getTopRatedMovies(page = currentPage)
            val responseData = mutableListOf<TopRatedMovies>()

//            val data = response.data?.movies?.map {
//                it.toTopRatedMovie()
//            }
//            if (data != null) {
//                responseData.addAll(data)
//            }

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