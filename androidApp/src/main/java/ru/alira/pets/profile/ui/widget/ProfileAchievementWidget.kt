package ru.alira.pets.profile.ui.widget

import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import ru.alira.pets.profile.ui.vo.AchievementVO
import ru.alira.pets.ui.util.text

@Composable
fun ProfileAchievementWidget(
    achievementVO: AchievementVO,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
    ) {
        Text(
            text = achievementVO.value.text(),
            style = MaterialTheme.typography.subtitle1,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )
        Text(
            text = achievementVO.description.text(),
            style = MaterialTheme.typography.subtitle2,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )
    }
}