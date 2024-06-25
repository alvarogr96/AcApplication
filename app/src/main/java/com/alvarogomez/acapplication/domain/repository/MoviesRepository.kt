package com.alvarogomez.acapplication.domain.repository

import com.alvarogomez.acapplication.domain.model.MovieResult
import retrofit2.Response

interface MoviesRepository {
    suspend fun getPopularMovies(
        language: String,
        page: Int?,
        region: String?
    ): Response<MovieResult>
}