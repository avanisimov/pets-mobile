package ru.alira.pets.chat.ui.vo

import ru.alira.pets.core.ui.ImageVO
import ru.alira.pets.core.ui.StringVO
import ru.alira.pets.core.ui.ViewObject

data class ChatListItemVO(
    override val id: String,
    val logo: ImageVO,
    val name: StringVO,
    val lastMessage: StringVO,
    val date: StringVO
) : ViewObject