package com.example.cinemaxv3.db.dao.movieDaos

import androidx.paging.PagingSource
import androidx.room.*
import com.example.cinemaxv3.models.TopRatedMovies
import com.example.cinemaxv3.util.ListConverter
import kotlinx.coroutines.flow.Flow

@TypeConverters(ListConverter::class)
@Dao
interface TopRatedMoviesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTopRatedMovies(topRatedMovies: List<TopRatedMovies>)

    @Query("SELECT * FROM toprated_movies Order By page")
    fun getTopRatedMovies(): PagingSource<Int, TopRatedMovies>

    @Query("Delete From  toprated_movies")
    suspend fun clearAllTopRatedMovies()
}