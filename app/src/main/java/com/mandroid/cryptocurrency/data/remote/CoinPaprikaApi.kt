package com.mandroid.cryptocurrency.data.remote

import com.mandroid.cryptocurrency.data.remote.dto.CoinDetailDto
import com.mandroid.cryptocurrency.data.remote.dto.CoinDto
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Manish Kumar on 28/06/22.
 */
interface CoinPaprikaApi {

    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinDetail(@Path("coinId") coinId: String): CoinDetailDto
}