package ru.alira.pets.login.ui

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.getAndUpdate
import kotlinx.coroutines.launch

interface LoginViewModel {
    val items: Flow<List<LoginMessageVO>>
    fun onAnswer()
}

class LoginViewModelImpl constructor(

) : LoginViewModel {
    private val messages: List<LoginMessageVO> = listOf(
        LoginMessageVO("Привет :)", source = LoginMessageSource.SYSTEM),
        LoginMessageVO("Добро пожаловать в мир питомцев!", source = LoginMessageSource.SYSTEM),
        LoginMessageVO("Уже знаешь про нас?", source = LoginMessageSource.SYSTEM),
        LoginMessageVO("Нет, расскажите", source = LoginMessageSource.USER),
        LoginMessageVO(
            "В нашем приложении ты можешь находить новых друзей своему питомцу",
            image = ImageVO(),//R.drawable.friends_search_example,
            source = LoginMessageSource.SYSTEM
        ),
        LoginMessageVO(
            "Общаться со знакомыми, делиться фотографиями и видео",
            image = ImageVO(),//R.drawable.pets_photos_example,
            source = LoginMessageSource.SYSTEM
        ),
        LoginMessageVO(
            "Узнавать новое про мир животных, делиться полезными советами",
            image = ImageVO(),//R.drawable.pets_news_example,
            source = LoginMessageSource.SYSTEM
        ),
        LoginMessageVO(
            "Найти зоомагазины и ветеринарные клиники рядом со своим домом",
            source = LoginMessageSource.SYSTEM
        ),
        LoginMessageVO("Готов присоедениться?", source = LoginMessageSource.SYSTEM),
        LoginMessageVO("Да", source = LoginMessageSource.USER),
        LoginMessageVO("Введи номер телефона", source = LoginMessageSource.SYSTEM),
        LoginMessageVO("+7 977 459-90-30", source = LoginMessageSource.USER),
        LoginMessageVO(
            "Мы отправили смс на номер +7 977 459-90-30",
            source = LoginMessageSource.SYSTEM
        ),
        LoginMessageVO(" * * * * ", source = LoginMessageSource.USER),
    )

    override val items = MutableStateFlow<List<LoginMessageVO>>(emptyList())

    override fun onAnswer() {
        TODO("Not yet implemented")
    }

    private val viewModelScope = CoroutineScope(Dispatchers.Default)

    init {
        viewModelScope.launch {
            messages.forEach { message ->
                items.getAndUpdate { currentList ->
                    currentList.toMutableList().apply {
                        add(0, message)
                    }
                }
                delay(2000)
            }
        }
    }


}


data class LoginMessageVO(
    val text: String,
    val image: ImageVO? = null,
    val source: LoginMessageSource
)

enum class LoginMessageSource {
    SYSTEM, USER
}

