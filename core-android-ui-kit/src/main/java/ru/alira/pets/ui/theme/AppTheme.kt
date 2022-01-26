package ru.alira.pets.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val LightColorPalette = lightColors(
    primary = Color.Teal700,
    background = Color.White,
    onBackground = Color.Black,
    onPrimary = Color.White,
    surface = Color.White,
    onSurface = Color.Black
)

@Composable
fun AppTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = LightColorPalette,
        typography = Typography,
        content = content
    )
}