package ru.alira.pets.core.ui

sealed class DataState<out T, out E : BaseError> {
    object Blank : DataState<Nothing, Nothing>()
    object Loading : DataState<Nothing, Nothing>()
    data class Ready<T>(
        val data: T
    ) : DataState<T, Nothing>()

    data class Error<E : BaseError>(
        val error: E
    ) : DataState<Nothing, E>()
}