package ru.alira.pets.login.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import ru.alira.pets.login.ui.ImageVO

@Composable
fun ImageVO.painter(): Painter {
    return when (this) {
        is ImageVO.Resource -> painterResource(this.res.drawableResId)
    }
}