package com.wamcstudios.cyptocurrencyapp.presentation.coin_list

sealed class CoinListEvent {
    data class OnClickCoin(val coinId: String) : CoinListEvent()

    data class ChangeValueQuery(val query: String) : CoinListEvent()
}