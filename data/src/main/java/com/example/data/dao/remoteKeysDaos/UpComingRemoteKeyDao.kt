package com.example.db.dao.remoteKeysDaos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cinemaxv3.models.TopRatedRemoteKeys
import com.example.cinemaxv3.models.UpComingRemoteKeys

@Dao
interface UpComingRemoteKeyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun  insertAllUpComingKeys(upComingRemoteKeys: List<UpComingRemoteKeys>)

    @Query("Select * From upcoming_remote_keys Where movie_id = :id")
    suspend fun getUpComingRemoteKeyByMovieID(id: Int): UpComingRemoteKeys?

    @Query("Delete From upcoming_remote_keys")
    suspend fun clearUpComingRemoteKeys()

    @Query("Select created_at From upcoming_remote_keys Order By created_at DESC LIMIT 1")
    suspend fun getUpComingCreationTime(): Long?


}