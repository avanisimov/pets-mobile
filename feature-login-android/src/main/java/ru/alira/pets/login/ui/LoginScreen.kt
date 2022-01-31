package ru.alira.pets.login.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.runtime.getValue
import ru.alira.pets.login.R
import ru.alira.pets.ui.theme.Color

@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel
) {
    val listItems: List<LoginMessageVO> by viewModel.items.collectAsState(emptyList())
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.primary)
    ) {
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            reverseLayout = true,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            items(listItems) { message ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            start = if (message.source == LoginMessageSource.SYSTEM) {
                                0.dp
                            } else {
                                56.dp
                            },
                            top = 4.dp,
                            end = if (message.source == LoginMessageSource.SYSTEM) {
                                56.dp
                            } else {
                                0.dp
                            },
                            bottom = 4.dp,
                        )
                ) {
                    Column(
                        modifier = Modifier
                            .border(
                                1.dp,
                                MaterialTheme.colors.onPrimary,
                                RoundedCornerShape(4.dp, 4.dp, 4.dp, 0.dp)
                            )
                            .padding(8.dp)
                            .align(
                                if (message.source == LoginMessageSource.SYSTEM) {
                                    Alignment.CenterStart
                                } else {
                                    Alignment.CenterEnd
                                }
                            )

                    ) {
                        Text(
                            text = message.text, color = MaterialTheme.colors.onPrimary
                        )
                        message.image?.let { image ->
                            Image(
                                painter = image.painter(),
                                contentDescription = null
                            )
                        }
                    }
                }
            }
        }
        Text(
            text = "",
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .background(Color.Teal700),
        )
    }
}
