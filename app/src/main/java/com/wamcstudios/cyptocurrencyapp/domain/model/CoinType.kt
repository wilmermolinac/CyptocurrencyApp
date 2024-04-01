package com.wamcstudios.cyptocurrencyapp.domain.model

sealed class CoinType(val name: String) {

    object Coin : CoinType(name = "coin")
    object Token : CoinType(name = "token")

    companion object {
        fun fromString(name: String): CoinType {
            return when (name) {
                "coin" -> Coin
                "token" -> Token
                else -> Coin
            }
        }
    }
}