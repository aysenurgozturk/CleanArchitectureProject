package com.example.newsproject.data.repository

import com.example.newsproject.data.remote.CoinPaprikaService

import com.example.newsproject.data.dto.CoinDto
import com.example.newsproject.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaService
) : CoinRepository {

    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }
}