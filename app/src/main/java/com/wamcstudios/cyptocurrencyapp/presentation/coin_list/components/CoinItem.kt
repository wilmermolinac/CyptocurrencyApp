package com.wamcstudios.cyptocurrencyapp.presentation.coin_list.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.wamcstudios.calorytracker.ui.theme.LocalSpacing
import com.wamcstudios.cyptocurrencyapp.R
import com.wamcstudios.cyptocurrencyapp.domain.model.Coin
import com.wamcstudios.cyptocurrencyapp.domain.model.CoinType

@Composable
fun CoinItem(modifier: Modifier = Modifier, item: Coin, onClick: () -> Unit) {

    val spacing = LocalSpacing.current

    ElevatedCard(modifier = modifier, onClick = { onClick() }, enabled = item.isActive) {

        Column(
            modifier = Modifier
                .padding(spacing.spaceSmall)
                .fillMaxWidth()
        ) {

            Text(
                text = "${item.rank}. ${item.name} (${item.symbol})",
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.ExtraBold,
                    color = MaterialTheme.colorScheme.primary
                )
            )
            Spacer(modifier = modifier.height(spacing.spaceNanoSmall))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = item.type.name,
                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)

                )

                val textActive = if (item.isActive) {
                    stringResource(id = R.string.active)
                } else {
                    stringResource(id = R.string.inactive)
                }

                Text(
                    text = textActive,
                    style = MaterialTheme.typography.titleSmall.copy(color = MaterialTheme.colorScheme.primary)
                )

            }


        }
    }

}

@Preview
@Composable
fun CoinItemPreview() {
    CoinItem(
        onClick = {},
        item = Coin(
            id = "asdasd",
            isNew = false,
            isActive = true,
            name = "Bitcoin",
            rank = 1,
            symbol = "BTC",
            type = CoinType.Coin
        )
    )
}