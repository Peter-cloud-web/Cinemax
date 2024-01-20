package com.example.data

import com.example.data.repository.RemoteMoviesRepositoryImpl
import com.example.domain.common.Resource
import com.google.common.io.Resources
import io.ktor.client.HttpClient
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okhttp3.mockwebserver.RecordedRequest
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import java.io.File
import java.net.HttpURLConnection

class TopRatedMovieTest {
    private lateinit var mockWebServer: MockWebServer
    private lateinit var repository: com.example.domain.repository.RemoteMoviesRepository
    private val json = Json {
        ignoreUnknownKeys = true
        isLenient = true
    }

    @Before
    fun setup() {
        // Setup MockWebServer
        mockWebServer = MockWebServer()
        mockWebServer.start()

        // Create a fake response for the top rated movies endpoint
        val mockResponse = MockResponse()
            .setResponseCode(HttpURLConnection.HTTP_OK)
            .setBody("/home/sean/StudioProjects/Cinemax/data/src/main/resources/movieresponse.json")

        // Set the dispatcher to return the mock response when the top rated movies endpoint is called
        mockWebServer.dispatcher = object : Dispatcher() {
            override fun dispatch(request: RecordedRequest): MockResponse {
                return when (request.path) {
                    "/movie/top_rated?api_key=201e657f776a56b669133086996d6564" -> mockResponse
                    else -> throw IllegalArgumentException("Unknown Request Path ${request.path}")
                }
            }
        }

//        val httpClient = MovieApi
//
//        // Create the repository with the mock web server URL
//        repository = RemoteMoviesRepositoryImpl()
    }

    @After
    fun teardown() {
        mockWebServer.shutdown()
    }

    @Test
    fun topRatedMovies_success() = runBlocking {
        // Call the repository to get the top rated movies
        val result = repository.getTopRatedMovies(1)

        // Assert that the result is a success
        assertEquals(Resource.Success::class.java, result.data?.movies!!::class.java)

        // Extract the data from the success result
        val data = (result as Resource.Success).data

        // Use assertions to verify the data as needed
        // For example, you could check the number of movies, the title of the first movie, etc.
        assertEquals(20, data?.movies)
        assertEquals("Avatar: The Way of Water", data?.movies?.get(0)?.title ?: null)
    }

    private fun getJson(path: String): String {
        val uri = Resources.getResource(path)
        val file = File(uri.path)
        return String(file.readBytes())
    }
}