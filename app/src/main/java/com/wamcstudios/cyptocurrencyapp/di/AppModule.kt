package com.wamcstudios.cyptocurrencyapp.di

import com.google.gson.GsonBuilder
import com.wamcstudios.cyptocurrencyapp.core.common.Constants
import com.wamcstudios.cyptocurrencyapp.data.remote.ApiService
import com.wamcstudios.cyptocurrencyapp.data.repository.CoinRepositoryImpl
import com.wamcstudios.cyptocurrencyapp.domain.repository.CoinRepository
import com.wamcstudios.cyptocurrencyapp.domain.use_case.CoinUseCases
import com.wamcstudios.cyptocurrencyapp.domain.use_case.GetCoinDetailById
import com.wamcstudios.cyptocurrencyapp.domain.use_case.GetCoins
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BASIC
        }).build()
    }

    @Provides
    @Singleton
    fun provideApiService(client: OkHttpClient): ApiService {
        val gson = GsonBuilder().setLenient().create()
        return Retrofit.Builder().baseUrl(Constants.BASE_URL).client(client).addConverterFactory(
            GsonConverterFactory.create(gson)
        ).build().create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: ApiService): CoinRepository {
        return CoinRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideCoinUseCases(repository: CoinRepository): CoinUseCases {
        return CoinUseCases(
            getCoins = GetCoins(repository),
            getCoinDetailById = GetCoinDetailById(repository)
        )
    }
}