package com.mandroid.cryptocurrency.presentation.coin_list

import com.mandroid.cryptocurrency.domain.model.Coin

/**
 * Created by Manish Kumar on 29/06/22.
 */
data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = listOf(),
    val error: String = ""
)
