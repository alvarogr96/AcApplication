package com.alvarogomez.acapplication.data.repository

import com.alvarogomez.acapplication.data.api.api.MovieApiService
import com.alvarogomez.acapplication.data.dto.response.MovieResponse
import com.alvarogomez.acapplication.data.dto.response.MoviesResponse
import com.alvarogomez.acapplication.domain.model.MovieModel
import com.alvarogomez.acapplication.domain.model.MovieResult
import com.alvarogomez.acapplication.domain.repository.MoviesRepository
import okhttp3.ResponseBody.Companion.toResponseBody
import retrofit2.Response
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(private val apiService: MovieApiService) :
    MoviesRepository {
    override suspend fun getPopularMovies(
        language: String,
        page: Int?,
        region: String?
    ): Response<MovieResult> {
        val response = apiService.getPopularMovies(language, page, region)

        return if (response.isSuccessful) {
            val movieDomain = response.body()?.convertToMovieResult()
            Response.success(movieDomain)
        } else {
            val errorBody = response.errorBody()?.string() ?: "Unknown Error"
            Response.error(response.code(), errorBody.toResponseBody())
        }

    }

    private fun MoviesResponse.convertToMovieResult(): MovieResult {
        return MovieResult(
            page,
            results.convertToMovieList(),
            total_pages,
            total_results
        )
    }

    private fun List<MovieResponse>.convertToMovieList(): List<MovieModel> {
        return this.map { it.convertToMovieModel() }
    }

    private fun MovieResponse.convertToMovieModel(): MovieModel {
        return MovieModel(
            adult,
            backdrop_path,
            genre_ids,
            id,
            original_language,
            original_title,
            overview,
            popularity,
            poster_path,
            release_date,
            title,
            video,
            vote_average,
            vote_count
        )
    }
}