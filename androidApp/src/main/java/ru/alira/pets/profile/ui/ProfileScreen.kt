package ru.alira.pets.profile.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import ru.alira.pets.core.ui.DataState
import ru.alira.pets.profile.ui.widget.ProfileAchievementWidget
import ru.alira.pets.profile.ui.widget.ProfileAvatarWidget
import ru.alira.pets.ui.theme.Color

@Composable
fun ProfileScreen(
    navController: NavController,
    viewModel: ProfileViewModel
) {
    val avatarState by viewModel.petAvatar.collectAsState(DataState.Blank)
    val achievementsState by viewModel.achievements.collectAsState(DataState.Blank)
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
//            .scrollable(
//                state = scrollState,
//                orientation = Orientation.Vertical
//            )
            .padding(start = 16.dp, end = 16.dp, bottom = 56.dp)
    ) {
        ProfileAvatarWidget(
            state = avatarState,
            modifier = Modifier
                .padding(horizontal = 48.dp, vertical = 32.dp)
                .fillMaxWidth()
                .aspectRatio(1f)
                .align(Alignment.CenterHorizontally)
        )
        when (val state = achievementsState) {
            DataState.Blank -> {}
            is DataState.Error -> {}
            DataState.Loading -> {}
            is DataState.Ready -> {
                Row(
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                ) {
                    state.data.forEach {
                        ProfileAchievementWidget(
                            achievementVO = it,
                            modifier = Modifier
                                .padding(horizontal = 8.dp)
                                .weight(1f)
                        )
                    }
                }
            }
        }

        Row(
            modifier = Modifier.padding(vertical = 8.dp)
        ) {
            Icon(
                imageVector = Icons.Default.PlayArrow,
                contentDescription = null
            )
            Text(
                text = "Фото и видео",
                color = Color.Black,
                fontSize = 12.sp,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .align(Alignment.CenterVertically)
            )
        }

        Row(
            modifier = Modifier.padding(vertical = 8.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Settings,
                contentDescription = null
            )
            Text(
                text = "Настройки",
                color = Color.Black,
                fontSize = 12.sp,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .align(Alignment.CenterVertically)
            )
        }
        Spacer(
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f)
        )
        Button(
            onClick = {

            },
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = "Выйти"
            )
        }
    }
}