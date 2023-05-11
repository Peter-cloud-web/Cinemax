package com.example.cinemaxv3.db.dao.movieDaos

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.TypeConverters
import com.example.cinemaxv3.models.responses.tvShowsResponse.TvShowsResults
import com.example.cinemaxv3.util.ListConverter

@TypeConverters(ListConverter::class)
@Dao
interface TopRatedTvShowsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertsTopRatedTvShows(topRatedTvShows:List<TvShowsResults>)

    @Query("SELECT * FROM toprated_movieshows Order By page")
    fun getTopRatedTvShows(): PagingSource<Int,TvShowsResults >

    @Query("Delete From toprated_movieshows")
    suspend fun clearAllMovies()
}