package com.mandroid.cryptocurrency.data.repository

import com.mandroid.cryptocurrency.data.remote.CoinPaprikaApi
import com.mandroid.cryptocurrency.data.remote.dto.CoinDetailDto
import com.mandroid.cryptocurrency.data.remote.dto.CoinDto
import com.mandroid.cryptocurrency.domain.model.Coin
import com.mandroid.cryptocurrency.domain.model.CoinDetail
import com.mandroid.cryptocurrency.domain.repository.CoinRepository
import javax.inject.Inject

/**
 * Created by Manish Kumar on 28/06/22.
 */
class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
): CoinRepository {

    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinDetail(coinId)
    }
}