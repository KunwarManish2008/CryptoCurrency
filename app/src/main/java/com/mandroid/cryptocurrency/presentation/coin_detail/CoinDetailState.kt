package com.mandroid.cryptocurrency.presentation.coin_detail

import com.mandroid.cryptocurrency.domain.model.CoinDetail

/**
 * Created by Manish Kumar on 29/06/22.
 */
data class CoinDetailState(
    val isLoading: Boolean = false,
    val coinDetail: CoinDetail? = null,
    val error: String = ""
)
