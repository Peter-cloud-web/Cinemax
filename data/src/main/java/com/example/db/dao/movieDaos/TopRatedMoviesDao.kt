package com.example.db.dao.movieDaos

import androidx.paging.PagingSource
import androidx.room.*
import com.example.cinemaxv3.models.TopRatedMovies
import com.example.db.dao.movieDaos.converters.ListConverter
import kotlinx.coroutines.flow.Flow


@Dao
interface TopRatedMoviesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTopRatedMovies(topRatedMovies: List<TopRatedMovies>)

    @Query("SELECT * FROM toprated_movies Order By page")
    fun getTopRatedMovies(): PagingSource<Int, TopRatedMovies>

    @Query("Delete From  toprated_movies")
    suspend fun clearAllTopRatedMovies()
}