package com.alvarogomez.acapplication.data.api.api

import com.alvarogomez.acapplication.data.api.endpoints.MoviesEndPoints
import com.alvarogomez.acapplication.data.dto.response.MoviesResponse
import retrofit2.Response
import javax.inject.Inject

class MovieApiService @Inject constructor(
    private val api: MoviesEndPoints
) {
    suspend fun getPopularMovies(
        language: String,
        page: Int?,
        region: String?
    ): Response<MoviesResponse> = api.getPopularMovies(language, page, region)
}