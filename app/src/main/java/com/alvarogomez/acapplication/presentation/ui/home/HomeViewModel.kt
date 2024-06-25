package com.alvarogomez.acapplication.presentation.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alvarogomez.acapplication.domain.usecase.GetPopularMoviesUseCase
import com.alvarogomez.acapplication.domain.utils.ResultType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val getPopularMoviesUseCase: GetPopularMoviesUseCase) :
    ViewModel() {

    private var _state = MutableStateFlow<HomeUiState>(HomeUiState.Unitialized)
    val state: StateFlow<HomeUiState> get() = _state.asStateFlow()

    init {
        getPopularMovies()
    }

    private fun getPopularMovies(language: String = "es", page: Int? = null, region: String? = null) {
        viewModelScope.launch {
            when(val response = getPopularMoviesUseCase(language, page, region).value) {
                is ResultType.Error -> _state.value = HomeUiState.Error("Error getting movies")
                is ResultType.Loading -> {}
                is ResultType.Success -> {
                    response.data?.let {
                        _state.value = HomeUiState.Success(it)
                    }
                }
            }
        }
    }
}