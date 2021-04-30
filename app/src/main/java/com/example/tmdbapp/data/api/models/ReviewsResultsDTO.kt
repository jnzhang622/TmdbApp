package com.example.tmdbapp.data.api.models

import com.google.gson.annotations.SerializedName

data class ReviewsResultsDTO (
    @SerializedName("author")val author: String,
    @SerializedName("content")val content: String,
    @SerializedName("updated_at")val updatedAt: String
)