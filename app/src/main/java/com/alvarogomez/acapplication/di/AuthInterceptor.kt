package com.alvarogomez.acapplication.di

import com.alvarogomez.acapplication.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request()
        val updateRequestBuilder = requestBuilder.newBuilder()

        updateRequestBuilder.addHeader(
            "Authorization",
            "Bearer ${BuildConfig.API_TOKEN}"
        )

        return chain.proceed(updateRequestBuilder.build())
    }
}