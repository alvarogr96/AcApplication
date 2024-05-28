package com.alvarogomez.acapplication.domain.usecase

import com.alvarogomez.acapplication.domain.utils.ResultType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import retrofit2.Response

fun <T> handleResponse(
    function: Response<T>,
    onSuccess: (T) -> Unit = {}
): StateFlow<ResultType<T>> {
    val result = MutableStateFlow<ResultType<T>>(ResultType.Loading())

    try {
        if (function.isSuccessful) {
            val data = function.body()
            data?.let { onSuccess(it) }
            result.value = ResultType.Success(data)
        } else {
            result.value = ResultType.Error(function.errorBody()?.toString() ?: "Unknown Error")
        }
    } catch (e: Exception) {
        result.value = ResultType.Error(e.message)
    }
    return result.asStateFlow()
}