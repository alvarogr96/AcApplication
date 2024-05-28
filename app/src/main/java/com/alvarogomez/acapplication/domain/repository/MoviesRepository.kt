package com.alvarogomez.acapplication.domain.repository

import com.alvarogomez.acapplication.data.dto.response.MoviesResponse
import retrofit2.Response

interface MoviesRepository {
    suspend fun getPopularMovies(
        language: String,
        page: Int?,
        region: String?
    ): Response<MoviesResponse>
}