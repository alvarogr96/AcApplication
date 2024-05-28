package com.alvarogomez.acapplication.di

import com.alvarogomez.acapplication.data.api.api.MovieApiService
import com.alvarogomez.acapplication.data.api.endpoints.MoviesEndPoints
import com.alvarogomez.acapplication.data.repository.MoviesRepositoryImpl
import com.alvarogomez.acapplication.domain.repository.MoviesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Singleton
    @Provides
    fun provideMoviesApiClient(retrofit: Retrofit): MoviesEndPoints {
        return retrofit.create(MoviesEndPoints::class.java)
    }

    @Singleton
    @Provides
    fun provideMoviesRepository(api: MovieApiService): MoviesRepository {
        return MoviesRepositoryImpl(api)
    }

}