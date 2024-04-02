package com.wamcstudios.cyptocurrencyapp.presentation.coin_detail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.wamcstudios.cyptocurrencyapp.R
import com.wamcstudios.cyptocurrencyapp.domain.model.CoinDetail

@Composable
fun CoinDetailItem(modifier: Modifier = Modifier, item: CoinDetail) {

    Box(modifier = modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {

            item {

            }
        }
    }


}

@Preview
@Composable
fun CoinDetailItemPreview() {
    /*CoinDetailItem(
        item = CoinDetail(
            description = "Is description item",
            developmentStatus = "Is developed",
            firstDataAt = "", hardwareWallet = true, hashAlgorithm = "Yes"
        )
    )*/
}