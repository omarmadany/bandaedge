package com.bandaedge.core.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// ── Brand Colors ───────────────────────────────────────
// Note: the value is yellow (0xFFFFEB3B); the name is kept to preserve the existing public naming.
private val BrandPink = Color(0xFFFFEB3B)

// ── Color Schemes ──────────────────────────────────────
private val LightColorScheme: ColorScheme = lightColorScheme(
    primary = BrandPink
)

private val DarkColorScheme: ColorScheme = darkColorScheme(
    primary = BrandPink
)

// ── Theme Selection ────────────────────────────────────
private fun selectColorScheme(isDarkTheme: Boolean): ColorScheme =
    if (isDarkTheme) DarkColorScheme else LightColorScheme

// ── Theme ──────────────────────────────────────────────
@Composable
fun BandaedgeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = selectColorScheme(isDarkTheme = darkTheme),
        content = content
    )
}