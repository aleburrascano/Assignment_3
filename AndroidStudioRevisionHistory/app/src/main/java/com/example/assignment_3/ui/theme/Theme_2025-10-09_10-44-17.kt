package com.example.assignment_3.ui.theme

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

private val DarkColorScheme = darkColorScheme(
    primary = DarkPrimaryGreen,
    secondary = DarkSecondaryGreen,
    tertiary = DarkSecondaryGreen,
    background = DarkBackground,
    surface = DarkSurface,
    onPrimary = Color(0xFF003823),
    onSecondary = Color(0xFF003823),
    onBackground = DarkTextPrimary,
    onSurface = DarkTextPrimary,
    surfaceVariant = Color(0xFF2A2A2A),
    onSurfaceVariant = DarkTextSecondary,
    primaryContainer = Color(0xFF1B4332),
    onPrimaryContainer = DarkPrimaryGreen,
    error = Color(0xFFCF6679),
    onError = Color.White
)

private val LightColorScheme = lightColorScheme(
    primary = PrimaryGreen,
    secondary = SecondaryGreen,
    tertiary = TertiaryMint,
    background = BackgroundCream,
    surface = SurfaceWhite,
    onPrimary = Color.White,
    onSecondary = Color.White,
    onBackground = TextDark,
    onSurface = TextDark,
    surfaceVariant = Color(0xFFF1F8F4),
    onSurfaceVariant = TextMedium,
    primaryContainer = Color(0xFFD7F5E7),
    onPrimaryContainer = PrimaryGreen,
    error = Color(0xFFD32F2F),
    onError = Color.White,
    outline = Color(0xFFB2DFDB),
    errorContainer = Color(0xFFF9DEDC),
    onErrorContainer = Color(0xFFD32F2F)
)

@Composable
fun Assignment_3Theme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
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

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}