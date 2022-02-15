package ru.alira.pets.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Scaffold
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import ru.alira.pets.navigation.AppBottomNavigation
import ru.alira.pets.navigation.Navigation
import ru.alira.pets.navigation.Routes
import ru.alira.pets.ui.theme.AppTheme

@AndroidEntryPoint
class AppActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppTheme {
                val navController = rememberNavController()
                val navBackStackEntry = navController.currentBackStackEntryAsState()
                val shouldShowBottomBar = navBackStackEntry.value?.destination?.route in listOf(
                    Routes.Feed,
                    Routes.Map,
                    Routes.Chat,
                    Routes.Profile,
                )
                Scaffold(bottomBar = {
                    if (shouldShowBottomBar) {
//                        BottomAppBar(
//                            modifier = Modifier.fillMaxWidth(),
//                            backgroundColor = MaterialTheme.colors.primary,
//                            elevation = 5.dp
//                        ) {
                        AppBottomNavigation(navController)
                    }
                }) {
                    Navigation(navController)
                }
            }
        }
    }
}