package com.example.newsproject.domain.repository

import com.example.newsproject.data.remote.dto.CoinDetailDto
import com.example.newsproject.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}