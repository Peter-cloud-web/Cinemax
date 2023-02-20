package com.example.cinemaxv3.paging.pagingSource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.cinemaxv3.models.Movie
import com.example.cinemaxv3.models.TopRatedMovies
import com.example.cinemaxv3.service.MovieApi
import retrofit2.HttpException
import javax.inject.Inject

class TopRatedMoviesPagingSource @Inject constructor(private val  service: MovieApi):PagingSource<Int, TopRatedMovies>() {
    override fun getRefreshKey(state: PagingState<Int, TopRatedMovies>): Int? {
        return 1
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, TopRatedMovies> {
        return try {
            val currentPage = params.key?:1
            val response = service.getTopRatedMovies(MovieApi.api_key,currentPage)
            val responseData = mutableListOf<TopRatedMovies>()
            val data = response.movies.isEmpty()
            responseData + data

            LoadResult.Page(data = responseData,
            prevKey = if(currentPage == 1)null else - 1,
            nextKey = currentPage.plus(1))

        }catch(e:Exception){
            LoadResult.Error(e)
        }catch (e:HttpException){
            LoadResult.Error(e)
        }
    }
}