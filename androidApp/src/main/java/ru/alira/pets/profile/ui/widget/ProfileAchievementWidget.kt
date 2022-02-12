package ru.alira.pets.profile.ui.widget

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
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
            color = Color.Black,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )
        Text(
            text = achievementVO.description.text(),
            color = Color.Black,
            fontSize = 8.sp,
            fontWeight = FontWeight.Thin,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )
    }
}