package com.alvarogomez.acapplication.data.api.endpoints

import com.alvarogomez.acapplication.data.dto.response.MoviesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesEndPoints {

    @GET ("movie/popular")
    suspend fun getPopularMovies(
        @Query("language") language: String? = null,
        @Query("page") page: Int? = null,
        @Query("region") region: String? = null,
    ): Response<MoviesResponse>
}