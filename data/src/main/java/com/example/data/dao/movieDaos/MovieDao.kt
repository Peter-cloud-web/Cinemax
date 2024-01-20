package com.example.db.dao.movieDaos

import androidx.paging.PagingSource
import androidx.room.*
import com.example.cinemaxv3.models.Movie
import com.example.db.dao.movieDaos.converters.ListConverter


@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPopularMovies(movie: List<Movie>)

    @Query("SELECT * FROM movies Order By page")
    fun getPopularMovies(): PagingSource<Int, Movie>

    @Query("Delete From movies")
    suspend fun clearAllMovies()
}