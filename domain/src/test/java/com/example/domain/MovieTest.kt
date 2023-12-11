import com.example.cinemaxv3.models.Movie
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.junit.Test
import net.javacrumbs.jsonunit.assertj.JsonAssertions.assertThatJson

class MovieTest {

    @Test
    fun `should serialize to JSON`() {
        // Given
        val movie = Movie(
            "backdrop_path",
            "original_title",
            "overview",
            "poster_path",
            123,
            "title",
            8.5,
            100,
            1
        )

        // When
        val json = Json { prettyPrint = true }.encodeToString(movie)

        // Then
        val expectedJson = """{
            "backdrop_path": "backdrop_path",
            "original_title": "original_title",
            "overview": "overview",
            "poster_path": "poster_path",
            "id": 123,
            "title": "title",
            "vote_average": 8.5,
            "vote_count": 100,
            "page": 1
        }"""

        assertThatJson(json).isEqualTo(expectedJson)
    }

    @Test
    fun `should deserialize from JSON`() {
        // Given
        val json = """{
            "backdrop_path": "backdrop_path",
            "original_title": "original_title",
            "overview": "overview",
            "poster_path": "poster_path",
            "id": 123,
            "title": "title",
            "vote_average": 8.5,
            "vote_count": 100,
            "page": 1
        }"""

        // When
        val movie = Json.decodeFromString<Movie>(json)

        // Then
        val expectedJson = """{
            "backdrop_path": "backdrop_path",
            "original_title": "original_title",
            "overview": "overview",
            "poster_path": "poster_path",
            "id": 123,
            "title": "title",
            "vote_average": 8.5,
            "vote_count": 100,
            "page": 1
        }"""

        assertThatJson(json).isEqualTo(expectedJson)
    }
}
