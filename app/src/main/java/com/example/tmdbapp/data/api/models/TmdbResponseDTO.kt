package com.example.tmdbapp.data.api.models

import com.google.gson.annotations.SerializedName

data class TmdbResponseDTO (
    @SerializedName("results")val results: List<TmdbResultsDTO>
)