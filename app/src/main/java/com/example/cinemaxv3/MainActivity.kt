package com.example.cinemaxv3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    private val TAG: String = MainActivity::class.java.getSimpleName()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fetchPopularMovies()
        fetchTopRatedMovies()
        fetchUpComingMovies()

       val popularMovies = MoviesAdapter(mutableListOf()){movie -> showMovieDetails(movie)  }

    }

    private fun fetchPopularMovies() {


        CoroutineScope(Dispatchers.Main).launch {

            try {
                val response = NetworkCall.invokeMovieApi.getPopularMovies(
                    "201e657f776a56b669133086996d6564",
                    2
                )

                if (response.isSuccessful && response.body() != null) {

                    val movies = response.body()

                    Log.d(TAG, "Movies : ${movies.toString()}")

                    movies?.let {
                        showPopularMovies(it)
                    }

                } else {

                    Toast.makeText(
                        this@MainActivity,
                        "Error Occurred: ${response.message()}",
                        Toast.LENGTH_LONG
                    ).show()
                }

            } catch (e: Exception) {
                Toast.makeText(
                    this@MainActivity,
                    "Error Occurred: ${e.message}",
                    Toast.LENGTH_LONG
                ).show()
            }

        }

    }

    private fun fetchTopRatedMovies() {



        CoroutineScope(Dispatchers.Main).launch {

            try {
                val response = NetworkCall.invokeMovieApi.getTopRatedMovies(
                    "201e657f776a56b669133086996d6564",
                    3
                )

                if (response.isSuccessful && response.body() != null) {


                    val movies = response.body()

                    Log.d(TAG, "Top Rated Movies : ${movies.toString()}")

                    movies?.let {
                        showTopRatedMovies(it)
                    }

                } else {

                    Toast.makeText(
                        this@MainActivity,
                        "Error Occurred: ${response.message()}",
                        Toast.LENGTH_LONG
                    ).show()
                }

            } catch (e: Exception) {
                Toast.makeText(
                    this@MainActivity,
                    "Error Occurred: ${e.message}",
                    Toast.LENGTH_LONG
                ).show()
            }

        }

    }

    private fun fetchUpComingMovies(){
        CoroutineScope(Dispatchers.Main).launch {

            try {

                val response = NetworkCall.invokeMovieApi.getUpcomingMovies(  "201e657f776a56b669133086996d6564",
                    4)

                if (response.isSuccessful && response.body() != null){
                    val movies = response.body()

                    Log.d(TAG, "Up coming Movies: ${movies.toString()}")

                    movies?.let {
                        showUpComingMovies(it)
                    }
                }else{

                    Toast.makeText(
                        this@MainActivity,
                        "Error Occurred: ${response.message()}",
                        Toast.LENGTH_LONG
                    ).show()

                }

            }catch (e:Exception){
                Toast.makeText(
                    this@MainActivity,
                    "Error Occurred: ${e.message}",
                    Toast.LENGTH_LONG
                ).show()
            }


        }
    }
        private fun showPopularMovies(movies: MovieResponse) {
            recyclerViewMovies.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            recyclerViewMovies.adapter = PopularMovieAdapter(movies.movies)
//            recyclerViewMovies.adapter = MoviesAdapter(mutableListOf()){movie -> showMovieDetails(movie) }


        }

    private fun showTopRatedMovies(movies: MovieResponse) {
        top_rated_movies.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        top_rated_movies.adapter = TopRatedMovieAdapter(movies)

    }

    private fun showUpComingMovies(movies: MovieResponse) {
        upcoming_movies.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        upcoming_movies.adapter = TopRatedMovieAdapter(movies)

    }

    private fun showMovieDetails(movie: Movie){
        val intent = Intent(this,MovieDetailsActivity::class.java)
        intent.putExtra(MOVIE_BACKDROP,movie.backdrop_path)
        intent.putExtra(MOVIE_POSTER,movie.poster_path)
        intent.putExtra(MOVIE_TITLE, movie.title)
        intent.putExtra(MOVIE_RATING, movie.vote_average)
        intent.putExtra(MOVIE_RELEASE_DATE, movie.release_date)
        intent.putExtra(MOVIE_OVERVIEW, movie.overview)
        startActivity(intent)
    }

    }
