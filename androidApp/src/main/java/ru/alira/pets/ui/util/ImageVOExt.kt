package ru.alira.pets.ui.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import coil.compose.rememberImagePainter
import ru.alira.pets.core.ui.ImageVO

@Composable
fun ImageVO.painter(): Painter {
    return when (this) {
        is ImageVO.Resource -> painterResource(this.res.drawableResId)
        is ImageVO.Url -> rememberImagePainter(this.url)
    }
}