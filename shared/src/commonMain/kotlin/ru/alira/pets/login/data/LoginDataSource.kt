package ru.alira.pets.login.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

interface LoginDataSource {
    suspend fun start(): Question
    suspend fun answer(questionId: String, answer: Answer?): Question
}

class LoginDataSourceProxy(
    val loginDataSource: LoginDataSource
) : LoginDataSource {
    val delay = 2_000L
    override suspend fun start(): Question {
        return withContext(Dispatchers.Default) {
            delay(2_000L)
            loginDataSource.start()
        }
    }

    override suspend fun answer(questionId: String, answer: Answer?): Question {

        return withContext(Dispatchers.Default) {
            delay(2_000L)
            loginDataSource.answer(questionId, answer)
        }
    }

}

class LoginDataSourceImpl : LoginDataSource {

    override suspend fun start(): Question {
        return withContext(Dispatchers.Default) {
            Question(
                id = "hello",
                text = "Привет!",
                type = QuestionType.Info
            )
        }
    }

    override suspend fun answer(questionId: String, answer: Answer?): Question {
        return when (questionId) {
            "hello" -> {
                Question(
                    id = "wellcome", text = "Добро пожаловать в мир питомцев!", type = QuestionType.Info
                )
            }
            "wellcome" -> {
                Question(
                    id = "do_u_know_about_us", text = "Уже знаешь про нас?", type = QuestionType.SingleChoice(
                        style = SingleChoiceStyle.BUTTONS, options = listOf(
                            ChoiceOption(
                                "do_u_know_about_us__yes", "Да"
                            ), ChoiceOption(
                                "do_u_know_about_us__no", "Нет"
                            )
                        )
                    )
                )
            }
            "do_u_know_about_us" -> handle_do_u_know_about_us(answer)
            "friends_search" -> {
                Question(
                    id = "media_share",
                    text = "Общаться со знакомыми, делиться фотографиями и видео",
                    type = QuestionType.Info
                )
            }
            "media_share" -> {
                Question(
                    id = "learn_more",
                    text = "Узнавать новое про мир животных, делиться полезными советами",
                    type = QuestionType.Info
                )
            }
            "learn_more" -> {
                Question(
                    id = "find_poi",
                    text = "Найти зоомагазины и ветеринарные клиники рядом со своим домом",
                    type = QuestionType.Info
                )
            }
            "find_poi" -> {
                Question(
                    id = "are_u_ready", text = "Готов присоедениться?", type = QuestionType.SingleChoice(
                        style = SingleChoiceStyle.BUTTONS, options = listOf(
                            ChoiceOption(
                                "are_u_ready__yes", "Да"
                            )
                        )
                    )
                )
            }
            "are_u_ready__yes" -> {
                Question(
                    id = "c",
                    text = "Введи номер телефона",
                    type = QuestionType.PhoneNumber(
                        id = "phone_number_value",
                        hint = "+7"
                    )
                )
            }
            "phone_number" -> {
                Question(
                    id = "phone_submit",
                    text = "Мы отправили смс на номер ${answer?.value}",
                    type = QuestionType.Password(
                        id = "phone_submit_code",
                        size = 6
                    )
                )
            }
            "phone_submit_code" -> {
                Question(
                    id = "finish",
                    text = "Мы отправили смс на номер ${answer?.value}",
                    type = QuestionType.Finish
                )
            }
            else -> throw IllegalArgumentException("Bad answer id")
        }
    }

    private fun handle_do_u_know_about_us(answer: Answer?): Question {
        return when (answer?.id) {
            "do_u_know_about_us__yes" -> {
                Question(
                    id = "phone_number",
                    text = "Введи номер телефона",
                    type = QuestionType.PhoneNumber(
                        id = "phone_number_value",
                        hint = "+7"
                    )
                )
            }
            "do_u_know_about_us__no" -> {
                Question(
                    id = "friends_search",
                    text = "В нашем приложении ты можешь находить новых друзей своему питомцу",
                    type = QuestionType.Info
                )
            }
            else -> throw IllegalArgumentException("Bad answer id for")
        }
    }
}