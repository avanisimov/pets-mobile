package ru.alira.pets.login.ui


import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.getAndUpdate
import ru.alira.pets.core.ui.BaseViewModel
import ru.alira.pets.core.ui.Clearable
import ru.alira.pets.core.util.CFlow
import ru.alira.pets.core.util.wrap
import ru.alira.pets.login.data.Answer
import ru.alira.pets.login.data.LoginDataSource
import ru.alira.pets.login.data.Question
import ru.alira.pets.login.data.QuestionType
import ru.alira.pets.login.domain.GetLoginHistoryUseCase
import ru.alira.pets.login.ui.vo.AnswerButton
import ru.alira.pets.login.ui.vo.AnswerState
import ru.alira.pets.login.ui.vo.LoginMessageSource
import ru.alira.pets.login.ui.vo.LoginMessageVO

interface LoginViewModel : Clearable {
    val loading: CFlow<Boolean>
    val items: CFlow<List<LoginMessageVO>>
    val answerState: CFlow<AnswerState>
    fun onAnswer(asnwerId: String, value: String?)
}

class LoginViewModelImpl constructor(
    private val getLoginHistoryUseCase: GetLoginHistoryUseCase,
    private val loginDataSource: LoginDataSource
) : BaseViewModel(), LoginViewModel {

    val _loading = MutableStateFlow(false)
    val _items = MutableStateFlow<List<LoginMessageVO>>(emptyList())
    val _answerState = MutableStateFlow<AnswerState>(AnswerState.Nothing)

    override val loading: CFlow<Boolean> = _loading.wrap()
    override val items: CFlow<List<LoginMessageVO>> = _items.wrap()
    override val answerState: CFlow<AnswerState> = _answerState.wrap()

    private var currentQuestion: Question? = null


    init {
        launch {
            _loading.emit(true)
            val messages = getLoginHistoryUseCase()
            _loading.emit(false)
//            messages.forEach { message ->
//                _items.getAndUpdate { currentList ->
//                    currentList.toMutableList().apply {
//                        add(0, startQuestion.toLoginMessageVO())
//                    }
//                }
//            }
            onNewQuestion(loginDataSource.start())
        }
    }

    private fun onNewQuestion(newQuestion: Question) {
        currentQuestion = newQuestion
        _items.getAndUpdate { currentList ->
            currentList.toMutableList().apply {
                add(0, newQuestion.toLoginMessageVO())
            }
        }
        val questionType = newQuestion.type
        when (questionType) {
            QuestionType.Info -> {
                onAnswer(newQuestion.id, null)
            }
            is QuestionType.Password -> {
                launch {
                    _answerState.emit(
                        AnswerState.Password(
                            questionType.id,
                            questionType.size,
                        )
                    )
                }
            }
            is QuestionType.PhoneNumber -> {
                launch {
                    _answerState.emit(
                        AnswerState.PhoneNumber(
                            questionType.id,
                            questionType.hint,
                        )
                    )
                }
            }
            is QuestionType.SingleChoice -> {
                launch {
                    _answerState.emit(AnswerState.Buttons(questionType.options.map {
                        AnswerButton(
                            it.id, it.text
                        )
                    }))
                }
            }
            QuestionType.Finish -> {
                // go to main app
            }
        }
    }

    override fun onAnswer(asnwerId: String, value: String?) {
        currentQuestion?.also { question ->
            launch {
                if (value != null) {
                    val text = if (question.type is QuestionType.Password) {
                        "******"
                    } else {
                        value
                    }
                    _items.getAndUpdate { currentList ->
                        currentList.toMutableList().apply {
                            add(
                                0, LoginMessageVO(
                                    text = text, image = null, source = LoginMessageSource.USER
                                )
                            )
                        }
                    }
                }
                onNewQuestion(loginDataSource.answer(question.id, Answer(asnwerId, value)))
            }
        }
    }
}


private fun Question.toLoginMessageVO(): LoginMessageVO {
    return LoginMessageVO(
        text = text, image = null, source = LoginMessageSource.SYSTEM
    )
}




