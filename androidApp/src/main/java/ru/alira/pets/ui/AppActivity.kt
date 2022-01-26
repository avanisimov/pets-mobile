package ru.alira.pets.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import ru.alira.pets.login.ui.LoginAndroidViewModel
import ru.alira.pets.login.ui.LoginDestination
import ru.alira.pets.login.ui.LoginScreen
import ru.alira.pets.ui.theme.AppTheme
import ru.alira.pets.ui.theme.Color

@AndroidEntryPoint
class AppActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                val navController = rememberNavController()
                val navBackStackEntry = navController.currentBackStackEntryAsState()
                val shouldShowBottombar = navBackStackEntry.value?.destination?.route in listOf(
                    "Feed"
                )
                Scaffold(bottomBar = {
                    if (shouldShowBottombar) {
//                        BottomAppBar(
//                            modifier = Modifier.fillMaxWidth(),
//                            backgroundColor = MaterialTheme.colors.primary,
//                            elevation = 5.dp
//                        ) {
                        BottomNavigation(
                            modifier = Modifier.fillMaxWidth(),
                        ) {
                            val items = listOf(
                                Icons.Default.List to "Feed",
                                Icons.Default.Place to "Map",
                                Icons.Outlined.Email to "Messaging",
                                Icons.Default.AccountCircle to "Profile",
                            )
                            items.forEach { item ->
                                BottomNavigationItem(selected = true,
                                    selectedContentColor = MaterialTheme.colors.onPrimary,
                                    unselectedContentColor = Color.Black,
                                    onClick = {

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
                                                fontSize = 10.sp,
                                                modifier = Modifier.align(Alignment.CenterHorizontally)
                                            )
                                        }
                                    })
                            }
//                            }
                        }
                    }
                }) {
                    Navigation(navController)
                }
            }
        }
    }
}

@Composable
fun Navigation(
    navController: NavHostController
) {
    NavHost(navController, startDestination = LoginDestination.route) {
        composable(LoginDestination.route) {
            LoginScreen(navController, hiltViewModel<LoginAndroidViewModel>())
        }
        composable(FeedDestination.route) {
            FeedScreen(navController)
        }
    }

}

object FeedDestination {
    val route = "Feed"
}

@Composable
fun FeedScreen(
    navController: NavController
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = "Feed", modifier = Modifier.align(Alignment.Center), color = Color.Black
        )
    }
}