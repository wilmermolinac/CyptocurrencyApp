package com.wamcstudios.cyptocurrencyapp.presentation.coin_detail

import com.wamcstudios.cyptocurrencyapp.domain.model.CoinDetail

data class CoinDetailState(val coinDetail: CoinDetail? = null, val isLoading: Boolean = false)