package com.example.db.dao.movieDaos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.TypeConverters
import com.example.db.dao.movieDaos.converters.ListConverter
import com.example.domain.entities.model.favourites.FavouriteMovies
import kotlinx.coroutines.flow.Flow


@Dao
interface FavouriteMoviesDao {

    @Query("SELECT * FROM favourite_movies")
    fun getAllFavouriteMovies(): Flow<List<FavouriteMovies>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavouriteMovies(movie: FavouriteMovies)

    @Query("DELETE FROM favourite_movies WHERE  id = :id")
    suspend fun deleteFavouriteMovie(id:Int)

}