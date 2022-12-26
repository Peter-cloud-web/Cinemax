package com.example.cinemaxv3.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.cinemaxv3.models.Movie
import com.example.cinemaxv3.service.MovieApi
import retrofit2.HttpException

class MoviePagingSource(private val service: MovieApi) : PagingSource<Int, Movie>() {
    override fun getRefreshKey(state: PagingState<Int, Movie>): Int{
      return 1
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        return try {
            val currentPage = params.key ?: 1
            val  response = service.getPopularMovies(MovieApi.api_key,currentPage)
            val responseData = mutableListOf<Movie>()
            val data = response.body()?.movies?: emptyList()
            responseData.addAll(data)

            LoadResult.Page(
                data = responseData,
                prevKey = if(currentPage == 1)null else -1,
                nextKey = currentPage.plus(1)


            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }catch (e:HttpException){
            LoadResult.Error(e)
        }
    }
}