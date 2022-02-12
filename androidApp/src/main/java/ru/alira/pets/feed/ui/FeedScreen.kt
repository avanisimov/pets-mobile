package ru.alira.pets.feed.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import ru.alira.pets.feed.ui.vo.FeedItemVO
import ru.alira.pets.feed.ui.widget.FeedItemWidget

@Composable
fun FeedScreen(
    navController: NavController,
    viewModel: FeedViewModel
) {
    val items by viewModel.items.collectAsState(emptyList())

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        items(items) { feedItem ->
            println("feedItem -> $feedItem")
            when (feedItem) {
                is FeedItemVO -> {
                    Box {
                        FeedItemWidget(feedItem)
                    }
                }
            }
        }
    }
}


