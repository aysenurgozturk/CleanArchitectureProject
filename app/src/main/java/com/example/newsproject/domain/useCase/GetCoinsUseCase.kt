package com.example.newsproject.domain.useCase

import com.example.newsproject.common.Resource
import com.example.newsproject.data.dto.toCoin
import com.example.newsproject.domain.model.Coin
import com.example.newsproject.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
//Coin(id=btc-bitcoin, isActive=true, name=Bitcoin, rank=1, symbol=BTC)
class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success(coins))
        } catch(e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "unexpected error"))
        } catch(e: IOException) {
            emit(Resource.Error("couldn't reach server."))
        }
    }
}