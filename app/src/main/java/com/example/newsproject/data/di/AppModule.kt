package com.example.newsproject.data.di

import com.example.newsproject.common.Constants
import com.example.newsproject.data.remote.CoinPaprikaService
import com.example.newsproject.data.repository.CoinRepositoryImpl
import com.example.newsproject.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePaprikaApi(): CoinPaprikaService {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaService::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(coinRepositoryImpl: CoinRepositoryImpl): CoinRepository = coinRepositoryImpl
}