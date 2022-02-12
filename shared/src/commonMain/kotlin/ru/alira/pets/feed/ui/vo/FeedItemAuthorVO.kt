package ru.alira.pets.feed.ui.vo


import ru.alira.pets.core.ui.ImageVO
import ru.alira.pets.core.ui.StringVO
import ru.alira.pets.core.ui.ViewObject


data class FeedItemAuthorVO(
    override val id: String,
    val name: StringVO,
    val image: ImageVO?,
) : ViewObject

fun a() {

}