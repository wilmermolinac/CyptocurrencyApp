package com.wamcstudios.cyptocurrencyapp.domain.model

data class Coin(
    val id: String,
    val isActive: Boolean,
    val isNew: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: CoinType,
)
