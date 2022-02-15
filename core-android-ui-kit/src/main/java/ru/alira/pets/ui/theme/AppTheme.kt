package ru.alira.pets.ui.theme

import android.annotation.SuppressLint
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Typography
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily

@SuppressLint("ConflictingOnColor")
private val LightColorPalette = lightColors(
    primary = Color.Teal700,
    primaryVariant = Color.Teal200,
    secondary = Color.Teal700,
    secondaryVariant = Color.Teal200,
    background = Color.White,
    surface = Color.White,
    error = Color.Red,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    onError = Color.Black,
)

@Composable
fun AppTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = LightColorPalette,
        typography = Typography(defaultFontFamily = FontFamily.Default),
        content = content
    )
}