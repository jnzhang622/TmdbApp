package com.example.tmdbapp.data.api.network

import com.example.tmdbapp.data.api.models.ReviewsResponseDTO
import com.example.tmdbapp.data.api.models.TmdbResponseDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

class TmdbManager {
    private val service: TmdbService
    private val retrofit = RetrofitService.providesRetrofitService()

    init {
        service = retrofit.create(TmdbService::class.java)
    }

//    fun getPopularTmdb(apiKey: String): Single<TmdbResponseDTO> {
//        return service.getPopularTmdb(apiKey)
//    }

    suspend fun getPopularTmdb(apiKey: String): Response<TmdbResponseDTO> {
        return service.getPopularTmdb(apiKey)
    }

    interface TmdbService {
//        @GET("/3/movie/popular")
//        fun getPopularTmdb(
//            @Query("api_key") apiKey: String,
//        ) : Single<TmdbResponseDTO>


        @GET("/3/movie/popular")
        suspend fun getPopularTmdb(
            @Query("api_key") apiKey: String,
        ): Response<TmdbResponseDTO>

//        @GET("/3/movie/{movie_id}")
//        suspend fun getMovie(@Path("movie_id") movieId: String,
//                             @Query("api_key") api_key: String
//        ): Response<IndividualMovieDTO>
//
        @GET("/3/movie/{movie_id}/reviews")
        suspend fun getReviews(@Path("movie_id") movieId: String,
                               @Query("api_key") api_key: String
        ): Response<ReviewsResponseDTO>
//
//        @GET("/3/movie/{movie_id}/videos")
//        suspend fun getVideos(@Path("movie_id") movieId: String,
//                              @Query("api_key") api_key: String
//        ): Response<VideosDTO>
    }
}