package ru.alira.pets.ui.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import ru.alira.pets.core.ui.StringVO

@Composable
fun StringVO.text(): String {
    return this.toString(context = LocalContext.current)
}
