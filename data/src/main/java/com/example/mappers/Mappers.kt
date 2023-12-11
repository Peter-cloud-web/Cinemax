import com.example.cinemaxv3.models.Movie
import com.example.cinemaxv3.models.TopRatedMovies
import com.example.cinemaxv3.models.UpComingMovies
import com.example.domain.movieDto.MovieDto
import com.example.domain.movieDto.TopRatedMoviesDto
import com.example.domain.movieDto.UpComingMoviesDto

object Mappers {
    fun MovieDto.toMovie(): Movie {
        return Movie(
            backdrop_path = backdrop_path,
            overview = overview,
            poster_path = poster_path,
            id = id,
            title = title,
            vote_average = vote_average,
            page = 1
        )
    }

    fun TopRatedMoviesDto.toTopRatedMovie(): TopRatedMovies {
        return TopRatedMovies(
            backdrop_path = backdrop_path,
            overview = overview,
            poster_path = poster_path,
            id = id,
            title = title,
            vote_average = vote_average,
            page = 1
        )
    }

    fun UpComingMoviesDto.toUpComingMovies(): UpComingMovies {
        return UpComingMovies(
            backdrop_path = backdrop_path,
            overview = overview,
            poster_path = poster_path,
            id = id,
            title = title,
            vote_average = vote_average,
            page = 1
        )
    }
}