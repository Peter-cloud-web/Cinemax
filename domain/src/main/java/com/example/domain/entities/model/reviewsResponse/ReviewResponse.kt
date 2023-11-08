package com.example.cinemaxv3.models.responses

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ReviewsResponse(
    @SerialName("id")
    val id: Int,
    @SerialName("page")
    val page: Int,
    @SerialName("results")
    val review: List<Review>,
    @SerialName("total_pages")
    val totalPages: Int,
    @SerialName("total_results")
    val totalResults: Int
)
@Serializable
data class Review(
    @SerialName("id")
    val id: String,
    @SerialName("author_details")
    val authorDetails: AuthorDetails,
    @SerialName("content")
    val content: String,
    @SerialName("created_at")
    val createdOn: String,
    @SerialName("url")
    val url: String
)
@Serializable
data class AuthorDetails(
    @SerialName("name")
    val name: String,
    @SerialName("username")
    val userName: String,
    @SerialName("avatar_path")
    val avatarPath: String?,
    @SerialName("rating")
    val rating: Double?,
)