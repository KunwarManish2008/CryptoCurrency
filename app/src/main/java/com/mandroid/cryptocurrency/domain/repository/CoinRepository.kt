package com.mandroid.cryptocurrency.domain.repository

import com.mandroid.cryptocurrency.data.remote.dto.CoinDetailDto
import com.mandroid.cryptocurrency.data.remote.dto.CoinDto
import com.mandroid.cryptocurrency.domain.model.Coin
import com.mandroid.cryptocurrency.domain.model.CoinDetail

/**
 * Created by Manish Kumar on 28/06/22.
 */
interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}