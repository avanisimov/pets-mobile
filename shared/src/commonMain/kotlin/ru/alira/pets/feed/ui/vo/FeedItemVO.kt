package ru.alira.pets.feed.ui.vo

import ru.alira.pets.core.ui.ImageVO
import ru.alira.pets.core.ui.StringVO
import ru.alira.pets.core.ui.ViewObject

data class FeedItemVO(
    override val id: String,
    val author: FeedItemAuthorVO,
    val date: StringVO,
    val text: StringVO,
    val images: List<ImageVO>?,
    val videoUrl: String?
) : ViewObject