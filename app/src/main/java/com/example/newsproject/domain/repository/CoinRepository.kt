package com.example.newsproject.domain.repository

import com.example.newsproject.data.dto.CoinDto

interface CoinRepository {
    suspend fun getCoins(): List<CoinDto>

}