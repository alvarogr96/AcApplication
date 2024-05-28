package com.alvarogomez.acapplication.domain.usecase

import com.alvarogomez.acapplication.data.dto.response.MoviesResponse
import com.alvarogomez.acapplication.domain.repository.MoviesRepository
import com.alvarogomez.acapplication.domain.utils.ResultType
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class GetPopularMoviesUseCase @Inject constructor(private val repository: MoviesRepository) {
    suspend operator fun invoke(
        language: String,
        page: Int?,
        region: String?
    ): StateFlow<ResultType<MoviesResponse>> =
        handleResponse(repository.getPopularMovies(language, page, region))
}