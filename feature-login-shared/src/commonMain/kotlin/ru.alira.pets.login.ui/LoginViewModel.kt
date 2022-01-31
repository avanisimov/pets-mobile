package ru.alira.pets.login.ui

import dev.icerock.moko.resources.ImageResource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.getAndUpdate
import kotlinx.coroutines.launch
import ru.alira.pets.MR
import ru.alira.pets.login.domain.uc.GetLoginHistoryUseCase

interface LoginViewModel {
    val loading: Flow<Boolean>
    val items: Flow<List<LoginMessageVO>>
    fun onAnswer()
}

class LoginViewModelImpl constructor(
    private val getLoginHistoryUseCase: GetLoginHistoryUseCase
) : LoginViewModel {

    override val loading = MutableStateFlow(false)

    override val items = MutableStateFlow<List<LoginMessageVO>>(emptyList())

    override fun onAnswer() {

        TODO("Not yet implemented")
    }

    private val viewModelScope = CoroutineScope(Dispatchers.Default)

    init {
        viewModelScope.launch {
            loading.emit(true)
            val messages = getLoginHistoryUseCase()
            loading.emit(false)
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

