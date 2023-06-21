package com.example.cinemaxv3.db.dao.movieDaos

import androidx.paging.PagingSource
import androidx.room.*
import com.example.cinemaxv3.models.UpComingMovies
import com.example.cinemaxv3.util.ListConverter
import kotlinx.coroutines.flow.Flow

@TypeConverters(ListConverter::class)
@Dao
interface UpComingMoviesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUpComingMovies(upComingMovies: List<UpComingMovies>)

    @Query("SELECT * FROM upcoming_movies Order By page")
    fun getUpComingMovies(): PagingSource<Int, UpComingMovies>

    @Query("Delete From  upcoming_movies")
    suspend fun clearAllUpComingMovies()
}