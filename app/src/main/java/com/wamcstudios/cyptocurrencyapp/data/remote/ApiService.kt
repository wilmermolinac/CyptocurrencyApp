package com.wamcstudios.cyptocurrencyapp.data.remote

import com.wamcstudios.cyptocurrencyapp.data.remote.dto.CoinDetailDto
import com.wamcstudios.cyptocurrencyapp.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailDto
}