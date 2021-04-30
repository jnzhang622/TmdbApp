package com.example.tmdbapp.repos

import com.example.tmdbapp.data.api.models.TmdbResponseDTO
import com.example.tmdbapp.data.api.network.TmdbManager
import io.reactivex.Single
import retrofit2.Response

class TmdbRepo {
//    fun getPopularTmdb(): Single<TmdbResponseDTO> {
//        return TmdbManager().getPopularTmdb(
//            "89e01707b395bc1c2eab67cf546da127"
//        )
//    }

    suspend fun getPopularTmdb(): Response<TmdbResponseDTO> {
        return TmdbManager().getPopularTmdb(
            ""
        )
    }




//    fun getSearchTmdb(searchTerm: String): Single<TmdbResponseDTO> {
//        return TmdbManager().getSearchTmdb(
//            "89e01707b395bc1c2eab67cf546da127", searchTerm
//        )
//    }
}