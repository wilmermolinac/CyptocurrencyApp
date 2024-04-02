package com.wamcstudios.calorytracker.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun rememberWindowInfo(): WindowInfo {
    // Obtenemos la configuración actual del dispositivo.
    val configuration = LocalConfiguration.current

    // Retornamos un objeto WindowInfo con la información de la ventana.
    return WindowInfo(
        // Dependiendo del ancho de la pantalla, se asigna un tipo de ventana.
        screenWidthInfo = when {
            // Si el ancho de la pantalla es menor a 600dp, se considera Compact.
            configuration.screenWidthDp < 600 -> WindowInfo.WindowType.Compact
            // Si el ancho de la pantalla es menor a 840dp pero mayor o igual a 600dp, se considera Medium.
            configuration.screenWidthDp < 840 -> WindowInfo.WindowType.Medium
            // Si el ancho de la pantalla es mayor o igual a 840dp, se considera Expanded.
            else -> WindowInfo.WindowType.Expanded
        },
        // Dependiendo de la altura de la pantalla, se asigna un tipo de ventana.
        screenHeightInfo = when {
            // Si la altura de la pantalla es menor a 480dp, se considera Compact.
            configuration.screenHeightDp < 480 -> WindowInfo.WindowType.Compact
            // Si la altura de la pantalla es menor a 840dp pero mayor o igual a 480dp, se considera Medium.
            configuration.screenHeightDp < 840 -> WindowInfo.WindowType.Medium
            // Si la altura de la pantalla es mayor o igual a 840dp, se considera Expanded.
            else -> WindowInfo.WindowType.Expanded
        },
        // Se asigna el ancho de la pantalla en dp.
        screenWidth = configuration.screenWidthDp.dp,
        // Se asigna la altura de la pantalla en dp.
        screenHeight = configuration.screenHeightDp.dp
    )
}

// Definición de la clase WindowInfo.
data class WindowInfo(
    // Tipo de ventana basado en el ancho de la pantalla.
    val screenWidthInfo: WindowType,
    // Tipo de ventana basado en la altura de la pantalla.
    val screenHeightInfo: WindowType,
    // Ancho de la pantalla en dp.
    val screenWidth: Dp,
    // Altura de la pantalla en dp.
    val screenHeight: Dp,
) {
    // Definición de los tipos de ventana.
    sealed class WindowType {
        // Tipo de ventana para pantallas pequeñas.
        object Compact : WindowType()
        // Tipo de ventana para pantallas medianas.
        object Medium : WindowType()
        // Tipo de ventana para pantallas grandes.
        object Expanded : WindowType()
    }
}
