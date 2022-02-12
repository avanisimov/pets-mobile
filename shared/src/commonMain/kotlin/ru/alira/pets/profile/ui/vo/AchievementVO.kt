package ru.alira.pets.profile.ui.vo

import ru.alira.pets.core.ui.StringVO
import ru.alira.pets.core.ui.ViewObject

data class AchievementVO(
    override val id: String,
    val value: StringVO,
    val description: StringVO
) : ViewObject