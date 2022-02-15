package ru.alira.pets.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val Typography = Typography(
    body1 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
//        color = MaterialTheme.colors.onBackground
    ),
    h1 = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 30.sp,
//        color = MaterialTheme.colors.onBackground
    ),
    h2 = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 24.sp,
//        color = MaterialTheme.colors.onBackground
    ),
    body2 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
//        color = MaterialTheme.colors.onBackground
    )
)