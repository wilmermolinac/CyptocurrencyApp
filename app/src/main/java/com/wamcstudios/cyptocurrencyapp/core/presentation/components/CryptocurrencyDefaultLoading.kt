package com.wamcstudios.cyptocurrencyapp.core.presentation.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CryptocurrencyDefaultLoading(modifier: Modifier = Modifier, isLoading: Boolean = false) {

    AnimatedVisibility(visible = isLoading) {
        Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    }


}

@Preview
@Composable
fun CryptocurrencyDefaultLoadingPreview() {
    CryptocurrencyDefaultLoading()
}