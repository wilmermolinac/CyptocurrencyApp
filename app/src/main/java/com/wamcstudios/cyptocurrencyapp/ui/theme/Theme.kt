package com.wamcstudios.cyptocurrencyapp.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import com.wamcstudios.calorytracker.ui.theme.BrightGreen
import com.wamcstudios.calorytracker.ui.theme.CompactDimensions
import com.wamcstudios.calorytracker.ui.theme.CompactTypography
import com.wamcstudios.calorytracker.ui.theme.DarkGray
import com.wamcstudios.calorytracker.ui.theme.DarkGreen
import com.wamcstudios.calorytracker.ui.theme.ExpandedDimensions
import com.wamcstudios.calorytracker.ui.theme.ExpandedTypography
import com.wamcstudios.calorytracker.ui.theme.LightGray
import com.wamcstudios.calorytracker.ui.theme.MediumDimensions
import com.wamcstudios.calorytracker.ui.theme.MediumGray
import com.wamcstudios.calorytracker.ui.theme.MediumTypography
import com.wamcstudios.calorytracker.ui.theme.Orange
import com.wamcstudios.calorytracker.ui.theme.ProvideAppUtils
import com.wamcstudios.calorytracker.ui.theme.TextWhite
import com.wamcstudios.calorytracker.ui.theme.WindowInfo
import com.wamcstudios.calorytracker.ui.theme.rememberWindowInfo

private val DarkColorScheme = darkColorScheme(
    primary = BrightGreen,
    primaryContainer = DarkGreen,
    secondary = Orange,
    background = MediumGray,
    onBackground = TextWhite,
    surface = LightGray,
    onSurface = TextWhite,
    onPrimary = Color.White,
    onSecondary = Color.White,
)

private val LightColorScheme = lightColorScheme(
    primary = BrightGreen,
    primaryContainer = DarkGreen,
    secondary = Orange,
    background = Color.White,
    onBackground = DarkGray,
    surface = Color.White,
    onSurface = DarkGray,
    onPrimary = Color.White,
    onSecondary = Color.White,
    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun CyptocurrencyAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit,
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    val windowInfo = rememberWindowInfo()
    var typography = CompactTypography
    var appDimens = CompactDimensions

    if (windowInfo.screenWidthInfo is WindowInfo.WindowType.Compact) {
        typography = CompactTypography
        appDimens = CompactDimensions
    }

    if (windowInfo.screenWidthInfo is WindowInfo.WindowType.Medium) {
        typography = MediumTypography
        appDimens = MediumDimensions
    }

    if (windowInfo.screenWidthInfo is WindowInfo.WindowType.Expanded) {
        typography = ExpandedTypography
        appDimens = ExpandedDimensions
    }


    ProvideAppUtils(appDimens = appDimens) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = typography,
            content = content
        )
    }

}