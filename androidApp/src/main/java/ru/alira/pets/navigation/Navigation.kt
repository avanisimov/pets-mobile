package ru.alira.pets.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.alira.pets.chat.ui.ChatListAndroidViewModel
import ru.alira.pets.chat.ui.ChatListScreen
import ru.alira.pets.feed.ui.FeedAndroidViewModel
import ru.alira.pets.feed.ui.FeedScreen
import ru.alira.pets.login.ui.LoginAndroidViewModel
import ru.alira.pets.login.ui.LoginScreen
import ru.alira.pets.map.MapScreen
import ru.alira.pets.profile.ui.ProfileAndroidViewModel
import ru.alira.pets.profile.ui.ProfileScreen

@Composable
fun Navigation(
    navController: NavHostController
) {
    NavHost(navController, startDestination = Routes.Feed) {
        composable(Routes.Login) {
            LoginScreen(navController, hiltViewModel<LoginAndroidViewModel>())
        }
        composable(Routes.Feed) {
            FeedScreen(navController, hiltViewModel<FeedAndroidViewModel>())
        }
        composable(Routes.Map) {
            MapScreen(navController)
        }
        composable(Routes.Profile) {
            ProfileScreen(navController, hiltViewModel<ProfileAndroidViewModel>())
        }
        composable(Routes.Chat) {
            ChatListScreen(navController, hiltViewModel<ChatListAndroidViewModel>())
        }
    }

}