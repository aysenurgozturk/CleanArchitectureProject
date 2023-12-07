package com.example.newsproject.data.remote

import com.example.newsproject.data.dto.CoinDto
import retrofit2.http.GET

interface CoinPaprikaService {

    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

}