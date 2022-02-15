package ru.alira.pets.feed.ui.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import ru.alira.pets.feed.ui.vo.FeedItemVO
import ru.alira.pets.ui.util.painter
import ru.alira.pets.ui.util.text


@Composable
fun FeedItemWidget(vo: FeedItemVO) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp, 4.dp)
    ) {
        Row {
            val painter = vo.author.image?.painter() ?: ColorPainter(Color.Red)
            Image(
                painter = painter,
                contentDescription = vo.author.toString(),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(48.dp)
                    .padding(8.dp)
                    .clip(CircleShape)                       // clip to the circle shape
                    .border(1.dp, Color.Gray, CircleShape),

                )

            Column {
                Text(
                    text = vo.author.name.text(),
                    style = MaterialTheme.typography.subtitle1
                )
                Text(
                    text = vo.date.text(),
                    style = MaterialTheme.typography.subtitle2
                )
            }
        }
        Text(
            text = vo.text.toString(context = LocalContext.current),
            style = MaterialTheme.typography.body1,
            maxLines = 3,
            overflow = TextOverflow.Ellipsis
        )
        if (vo.images.isNullOrEmpty()) {
            vo.images?.forEach { imageVO ->
                Image(
                    painter = imageVO.painter(),
                    contentDescription = null,
                )
            }
        } else if (vo.videoUrl.isNullOrEmpty()) {

        }
    }
}