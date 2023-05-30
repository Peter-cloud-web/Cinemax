package com.example.cinemaxv3.db.dao.movieDaos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cinemaxv3.domain.model.favourites.FavouriteMovies
import kotlinx.coroutines.flow.Flow


@Dao
interface FavouriteMoviesDao {

    @Query("SELECT * FROM favourite_movies")
    fun getAllFavouriteMovies(): Flow<List<FavouriteMovies>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavouriteMovies(movie: FavouriteMovies)

}