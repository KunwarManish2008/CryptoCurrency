package com.mandroid.cryptocurrency.domain.model

/**
 * Created by Manish Kumar on 28/06/22.
 */
data class Coin(
    val id: String,
    val isActive: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
)
