package ru.alira.pets.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.outlined.Email
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import ru.alira.pets.ui.theme.Color

@Composable
fun AppBottomNavigation(
    navController: NavController
) {
    BottomNavigation(
        modifier = Modifier.fillMaxWidth(),
    ) {
        val items = listOf(
            Icons.Default.List to Routes.Feed,
            Icons.Default.Place to Routes.Map,
            Icons.Outlined.Email to Routes.Chat,
            Icons.Default.AccountCircle to Routes.Profile,
        )
        items.forEach { item ->
            BottomNavigationItem(selected = true,
                selectedContentColor = MaterialTheme.colors.onPrimary,
                unselectedContentColor = Color.Black,
                onClick = {
                    navController.navigate(item.second)
                },
                icon = {
                    Column(
                        modifier = Modifier.align(Alignment.CenterVertically)
                    ) {
                        Icon(
                            imageVector = item.first,
                            contentDescription = item.second,
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                        )
                        Text(
                            text = item.second,
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                        )
                    }
                })
        }
//                            }
    }
}