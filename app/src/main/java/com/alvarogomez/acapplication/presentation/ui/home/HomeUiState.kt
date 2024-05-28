package com.alvarogomez.acapplication.presentation.ui.home

import com.alvarogomez.acapplication.domain.model.MovieResult

sealed class HomeUiState {
    object Unitialized: HomeUiState()
    object Loading: HomeUiState()
    class Success(val response: MovieResult): HomeUiState()
    class Error(val msg: String): HomeUiState()
}