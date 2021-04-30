package com.example.tmdbapp.data.api.models

import com.google.gson.annotations.SerializedName

data class TmdbResultsDTO (
    @SerializedName("id")val id: Int,
    @SerializedName("title")val title: String,
    @SerializedName("overview")val overview: String,
    @SerializedName("release_date")val releaseDate: String,
    @SerializedName("popularity")val popularity: Double,
    @SerializedName("poster_path")val posterPath: String,
    @SerializedName("vote_average")val voteAverage: String,
    @SerializedName("vote_count")val voteCount: Int
    )