package com.alvarogomez.acapplication.domain.model

import com.alvarogomez.acapplication.data.dto.response.MovieResponse
import com.alvarogomez.acapplication.data.dto.response.MoviesResponse


fun MoviesResponse.convertToMovieResult(): MovieResult {
    return MovieResult(
        page,
        results.convertToMovieList(),
        total_pages,
        total_results
    )
}

fun List<MovieResponse>.convertToMovieList(): List<MovieModel> {
    return this.map { it.convertToMovieModel() }
}

fun MovieResponse.convertToMovieModel(): MovieModel {
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