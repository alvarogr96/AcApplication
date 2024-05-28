package com.alvarogomez.acapplication.domain.utils

sealed class ResultType<T> {

    data class Success<T>(val data: T?) : ResultType<T>()
    data class Error<T>(val msg: String?) : ResultType<T>()
    class Loading<out T> : ResultType<@UnsafeVariance T>()
}