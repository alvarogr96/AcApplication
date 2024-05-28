package com.alvarogomez.acapplication.data.repository

import com.alvarogomez.acapplication.data.api.api.MovieApiService
import com.alvarogomez.acapplication.data.dto.response.MoviesResponse
import com.alvarogomez.acapplication.domain.repository.MoviesRepository
import retrofit2.Response
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(private val apiService: MovieApiService) :
    MoviesRepository {
    override suspend fun getPopularMovies(
        language: String,
        page: Int?,
        region: String?
    ): Response<MoviesResponse> = apiService.getPopularMovies(language, page, region)
}