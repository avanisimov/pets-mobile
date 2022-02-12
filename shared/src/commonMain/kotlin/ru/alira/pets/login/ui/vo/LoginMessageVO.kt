package ru.alira.pets.login.ui.vo

import ru.alira.pets.core.ui.ImageVO


data class LoginMessageVO(
    val text: String,
    val image: ImageVO? = null,
    val source: LoginMessageSource
)

enum class LoginMessageSource {
    SYSTEM, USER
}