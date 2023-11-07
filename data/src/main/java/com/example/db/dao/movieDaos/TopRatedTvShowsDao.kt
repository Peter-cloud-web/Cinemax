package com.example.db.dao.movieDaos

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.TypeConverters
import com.example.db.dao.movieDaos.converters.ListConverter

import com.example.entities.model.tvShowsResponse.TvShowsResults


@Dao
@TypeConverters(ListConverter::class)
interface TopRatedTvShowsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertsTopRatedTvShows(topRatedTvShows: List<com.example.entities.model.tvShowsResponse.TvShowsResults>)

    @Query("SELECT * FROM toprated_movieshows Order By page")
    fun getTopRatedTvShows(): PagingSource<Int, com.example.entities.model.tvShowsResponse.TvShowsResults>

    @Query("Delete From toprated_movieshows")
    suspend fun clearAllMovies()
}