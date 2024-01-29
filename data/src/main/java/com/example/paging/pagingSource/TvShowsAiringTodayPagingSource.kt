package com.example.paging.pagingSource

import android.annotation.SuppressLint
import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.domain.entities.model.tvShowsResponse.TvShowsResults
import com.example.domain.repository.RemoteMoviesRepository
import retrofit2.HttpException
import javax.inject.Inject


class TvShowsAiringTodayPagingSource @Inject constructor(
    private val repository: RemoteMoviesRepository
) : PagingSource<Int, TvShowsResults>() {
    override fun getRefreshKey(state: PagingState<Int, TvShowsResults>): Int? {
        return state.anchorPosition?.let { lastAccessedPosition ->
            state.closestPageToPosition(lastAccessedPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(lastAccessedPosition)?.nextKey?.minus(1)
        }
    }

    @SuppressLint("SuspiciousIndentation")
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, TvShowsResults> {
        return try {
            val currentKey = params.key ?: 1
            val response = repository.getTvShowsAiringToday(page = currentKey)
            val responseData = response.data?.results ?: emptyList()


                LoadResult.Page(
                    data = responseData,
                    prevKey = if (currentKey > 0) currentKey - 1 else null,
                    nextKey =  currentKey + 1
                )
        } catch (e: Exception) {
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        }
    }
}
//}class TvShowsAiringTodayPagingSource @Inject constructor(
//    private val repository: RemoteMoviesRepository
//) : PagingSource<Int, TvShowsResults>() {
//    override fun getRefreshKey(state: PagingState<Int, TvShowsResults>): Int? {
//        return 1
////        return state.anchorPosition?.let {lastAccessedPosition ->
////            state.closestPageToPosition(lastAccessedPosition)?.prevKey?.plus(1)
////                ?: state.closestPageToPosition(lastAccessedPosition)?.nextKey?.minus(1)
////        }
//    }
//
//        override suspend fun load(params: LoadParams<Int>): LoadResult<Int, TvShowsResults> {
//            return try {
//                val currentKey = params.key ?: 1
//                val response = repository.getTvShowsAiringToday(page = currentKey)
//                val responseData = mutableListOf<TvShowsResults>()
//                response.data?.results?.let { responseData.addAll(it) }
//
//                LoadResult.Page(
//                    data = responseData,
//                    prevKey = if (currentKey > 0) currentKey - 1 else null,
//                    nextKey = if (response.data!!.results.isNotEmpty()) currentKey + 1 else null
//                )
//            } catch (e: Exception) {
//                LoadResult.Error(e)
//            } catch (e: HttpException) {
//                LoadResult.Error(e)
//            }
//        }
//    }
