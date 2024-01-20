package com.example.db.dao.remoteKeysDaos

import com.example.cinemaxv3.models.MovieRemoteKeys
import androidx.room.*

@Dao
interface RemoteKeysDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun  insertAllKeys(remoteKey:List<MovieRemoteKeys>)

    @Query("Select * From remote_key Where movie_id = :id")
    suspend fun getRemoteKeyByMovieID(id: Int): MovieRemoteKeys?

    @Query("Delete From remote_key")
    suspend fun clearRemoteKeys()

    @Query("Select created_at From remote_key Order By created_at DESC LIMIT 1")
    suspend fun getCreationTime(): Long?
}