package com.example.data

import Mappers.toMovie
import com.example.cinemaxv3.models.Movie
import com.example.domain.movieDto.MovieDto
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class MappersTests {
    @Test
    fun testPopularMovieDtoToPopularMovie() {
        val dto = MovieDto(
            adult = true,
            backdrop_path = "backdrop.jpg",
            genre_ids = null,
            original_language = "English",
            original_title = "Black panther",
            overview = "A thrilling movie...",
            popularity = null,
            poster_path = "poster.jpg",
            release_date = null,
            id = 123,
            title = "The Movie Title",
            video = false,
            vote_average = 8.5,
            vote_count = null
        )

        val expectedMovie = Movie(
            backdrop_path = "backdrop.jpg",
            overview = "A thrilling movie...",
            poster_path = "poster.jpg",
            id = 123,
            title = "The Movie Title",
            vote_average = 8.5,
            page = 1
        )

        val actualMovie = dto.toMovie()

        assertEquals(expectedMovie, actualMovie)
    }
}