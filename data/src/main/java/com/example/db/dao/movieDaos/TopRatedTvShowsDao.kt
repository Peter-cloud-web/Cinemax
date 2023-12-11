package com.example.db.dao.movieDaos

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.TypeConverters
import com.example.db.dao.movieDaos.converters.ListConverter

import com.example.domain.entities.model.tvShowsResponse.TvShowsResults


@Dao
interface TopRatedTvShowsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertsTopRatedTvShows(topRatedTvShows: List<TvShowsResults>)

    @Query("SELECT * FROM toprated_movieshows Order By page")
    fun getTopRatedTvShows(): PagingSource<Int, TvShowsResults>

    @Query("Delete From toprated_movieshows")
    suspend fun clearAllMovies()
}