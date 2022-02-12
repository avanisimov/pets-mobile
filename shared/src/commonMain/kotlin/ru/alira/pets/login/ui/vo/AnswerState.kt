package ru.alira.pets.login.ui.vo

sealed class AnswerState {
    object Nothing : AnswerState()
    data class Buttons(
        val buttons: List<AnswerButton>
    ) : AnswerState()

    data class PhoneNumber(
        val answerId: String,
        val hint: String
    ) : AnswerState()

    data class Password(
        val answerId: String,
        val size: Int
    ) : AnswerState()
}

data class AnswerButton(
    val answerId: String, val text: String
)