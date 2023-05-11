package com.example.cinemaxv3.paging.pagingSource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.cinemaxv3.models.Movie
import com.example.cinemaxv3.models.UpComingMovies
import com.example.cinemaxv3.service.MovieApi
import retrofit2.HttpException
import javax.inject.Inject

class UpComingMoviesPagingSource @Inject constructor(private val service:MovieApi):PagingSource<Int, UpComingMovies>() {
    override fun getRefreshKey(state: PagingState<Int, UpComingMovies>): Int? {
        return 1
    }
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UpComingMovies> {
        return try {
            val currentPage = params.key?:1
            val response = service.upComingMovies(MovieApi.api_key,currentPage)
            val responseData = mutableListOf<UpComingMovies>()
            responseData.addAll(response.movies)


            LoadResult.Page(data = responseData,
            prevKey = if(currentPage == 1)null else -1,
            nextKey = currentPage.plus (1))

        }catch(e:Exception){
            LoadResult.Error(e)
        }catch (e:HttpException){
            LoadResult.Error(e)
        }
    }
}