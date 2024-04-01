package com.wamcstudios.cyptocurrencyapp.presentation.coin_list

import com.wamcstudios.cyptocurrencyapp.core.utils.UiText
import com.wamcstudios.cyptocurrencyapp.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coinsList: List<Coin> = emptyList(),
    val query: String = "", val queryMsgError: UiText? = null,
)
