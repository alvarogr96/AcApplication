package com.alvarogomez.acapplication.data.dto.response

data class MoviesResponse(
    val page: Int,
    val results: List<MovieResponse>,
    val total_pages: Int,
    val total_results: Int
)