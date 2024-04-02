package com.wamcstudios.calorytracker.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalConfiguration

@Composable
fun ProvideAppUtils(
    appDimens: Dimensions,
    content: @Composable () -> Unit,
) {
    val appDimens = remember { appDimens }

    CompositionLocalProvider(LocalSpacing provides appDimens) {
        content()
    }
}

// Creamos un espacio local que nos sirve para pasar valores especificos por compositionLocal
val LocalSpacing = compositionLocalOf {
    CompactDimensions
}

val ScreenOrientation
    @Composable get() = LocalConfiguration.current.orientation