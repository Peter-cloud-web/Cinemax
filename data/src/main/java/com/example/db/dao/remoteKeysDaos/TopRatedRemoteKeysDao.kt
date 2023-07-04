package com.example.db.dao.remoteKeysDaos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cinemaxv3.models.MovieRemoteKeys
import com.example.cinemaxv3.models.TopRatedRemoteKeys

@Dao
interface TopRatedRemoteKeysDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun  insertAllTopRatedKeys(topRatedRemoteKeys: List<TopRatedRemoteKeys>)

    @Query("Select * From toprated_remote_key Where movie_id = :id")
    suspend fun getTopRatedRemoteKeyByMovieID(id: Int): TopRatedRemoteKeys?

    @Query("Delete From toprated_remote_key")
    suspend fun clearTopRatedRemoteKeys()

    @Query("Select created_at From toprated_remote_key Order By created_at DESC LIMIT 1")
    suspend fun getTopRatedCreationTime(): Long?
}