package ru.alira.pets.login.data

class Question(
    val id: String,
    val text: String,
    val type: QuestionType
)

sealed class QuestionType {
    object Info : QuestionType()
    data class SingleChoice(
        val style: SingleChoiceStyle,
        val options: List<ChoiceOption>
    ) : QuestionType()

    data class PhoneNumber(
        val id: String,
        val hint: String
    ) : QuestionType()

    data class Password(
        val id: String,
        val size: Int
    ) : QuestionType()

    object Finish : QuestionType()
}

enum class SingleChoiceStyle {
    BUTTONS
}

data class ChoiceOption(
    val id: String,
    val text: String
)