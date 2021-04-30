package com.example.tmdbapp.data.api.models

import com.google.gson.annotations.SerializedName

data class ReviewsResponseDTO (
    @SerializedName("results")val results: List<ReviewsResultsDTO>
)