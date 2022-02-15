package ru.alira.pets.profile.ui.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ru.alira.pets.core.ui.BaseError
import ru.alira.pets.core.ui.DataState
import ru.alira.pets.profile.ui.PetAvatarVO
import ru.alira.pets.ui.util.painter
import ru.alira.pets.ui.util.text

@Composable
fun ProfileAvatarWidget(
    state: DataState<PetAvatarVO, BaseError>,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .clip(CircleShape)
    ) {
        when (state) {
            DataState.Blank -> {

            }
            is DataState.Error -> {

            }
            DataState.Loading -> {

            }
            is DataState.Ready -> {
                Image(
                    painter = state.data.imageVO.painter(),
                    contentDescription = state.data.id,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(bottom = 48.dp)
                        .fillMaxSize()
                )
                Text(
                    text = state.data.name.text(),
                    style = MaterialTheme.typography.h6,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colors.onPrimary,
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .height(48.dp)
                        .fillMaxWidth()
                        .background(MaterialTheme.colors.primary),

                    )
            }
        }

    }
}