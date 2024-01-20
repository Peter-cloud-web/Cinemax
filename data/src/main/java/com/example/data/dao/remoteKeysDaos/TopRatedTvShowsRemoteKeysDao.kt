package com.example.db.dao.remoteKeysDaos

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cinemaxv3.models.TopRatedTvShowsRemoteKeys
import com.example.cinemaxv3.models.UpComingMovies

@Dao
interface TopRatedTvShowsRemoteKeysDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTopRatedTvShowsRemoteKeys(topRatedTvShowsRemoteKeys:List<TopRatedTvShowsRemoteKeys>)

    @Query("SELECT * FROM toprated_tvshows_remote_keys Where movie_id = :id")
    suspend fun getTopRatedTvShowsRemoteKeysById(id:Int): TopRatedTvShowsRemoteKeys

    @Query("Delete From  toprated_tvshows_remote_keys")
    suspend fun clearTopRatedTvShowsRemoteKeys()

    @Query("Select created_at From toprated_tvshows_remote_keys Order By created_at DESC LIMIT 1")
    suspend fun getTopRatedTvShowsRemoteKeysCreaionTime(): Long?
}