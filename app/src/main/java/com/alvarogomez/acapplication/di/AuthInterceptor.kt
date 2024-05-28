package com.alvarogomez.acapplication.di

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request()
        val updateRequestBuilder = requestBuilder.newBuilder()

        updateRequestBuilder.addHeader(
            "Authorization",
            "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI0OTMxYWI5Njg3ZDRjOTU4NGQ0ZmJhODdkMTg1Nzc2NSIsInN1YiI6IjYzYTBlYzc2MmYzYjE3MDA3Y2E2OGFiMSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.YlN5n2oiKbU0hPbEHUuPTIOnRiM6GM3yFNDSGl07mj4"
        )

        return chain.proceed(updateRequestBuilder.build())
    }
}