package ru.alira.pets.login.ui

import dev.icerock.moko.resources.ImageResource

sealed class ImageVO {
    data class Resource(
        val res: ImageResource
    ):ImageVO()
}