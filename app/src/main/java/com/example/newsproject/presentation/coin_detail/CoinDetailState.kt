package com.example.newsproject.presentation.coin_detail
import com.example.newsproject.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
