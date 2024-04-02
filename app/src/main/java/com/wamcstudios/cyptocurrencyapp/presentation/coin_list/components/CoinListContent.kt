package com.wamcstudios.cyptocurrencyapp.presentation.coin_list.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.wamcstudios.calorytracker.ui.theme.LocalSpacing
import com.wamcstudios.cyptocurrencyapp.core.presentation.components.CryptocurrencyDefaultLoading
import com.wamcstudios.cyptocurrencyapp.domain.model.Coin
import com.wamcstudios.cyptocurrencyapp.presentation.coin_list.CoinListEvent
import com.wamcstudios.cyptocurrencyapp.presentation.coin_list.CoinListState

@Composable
fun CoinListContent(
    modifier: Modifier = Modifier,
    state: CoinListState,
    onEvent: (CoinListEvent) -> Unit,
) {

    val spacing = LocalSpacing.current

    Box(modifier = modifier.fillMaxSize()) {

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(
                top = spacing.spaceMediumExtra,
                start = spacing.spaceMedium,
                end = spacing.spaceMedium, bottom = spacing.spaceLargeMedium
            ), verticalArrangement = Arrangement.spacedBy(spacing.spaceSmall)
        ) {

            items(state.coinsList) { item: Coin ->

                CoinItem(item = item, onClick = { onEvent(CoinListEvent.OnClickCoin(item.id)) })

            }

        }

        CryptocurrencyDefaultLoading(isLoading = state.isLoading)

    }
}

