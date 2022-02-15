package ru.alira.pets.chat.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.alira.pets.chat.ui.vo.ChatListItemVO
import ru.alira.pets.ui.util.painter
import ru.alira.pets.ui.util.text

@Composable
fun ChatListScreen(
    navController: NavController,
    viewModel: ChatListViewModel
) {
    val items by viewModel.items.collectAsState(emptyList())

    Surface {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {
            items(items) { item ->
                when (item) {
                    is ChatListItemVO -> {
                        Box {
                            Row {
                                Image(
                                    painter = item.logo.painter(),
                                    contentDescription = null,
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .padding(8.dp)
                                        .size(48.dp)
                                        .clip(CircleShape)
                                )
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .align(Alignment.CenterVertically)
                                        .padding(vertical = 8.dp)
                                ) {
                                    Text(
                                        text = item.name.text(),
                                        style = MaterialTheme.typography.subtitle2,
                                        maxLines = 1,
                                    )
                                    Row(
                                        modifier = Modifier.fillMaxWidth()
                                    ) {
                                        Text(
                                            text = item.lastMessage.text(),
                                            style = MaterialTheme.typography.caption,
                                            maxLines = 1,

                                            )
                                        Text(
                                            text = item.date.text(),
                                            style = MaterialTheme.typography.caption,
                                            maxLines = 1,
                                        )
                                    }
                                }
                            }

                        }
                    }
                }
            }
        }
    }

}


