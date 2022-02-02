package ru.alira.pets.login.ui


import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.getAndUpdate
import kotlinx.coroutines.launch
import ru.alira.pets.core.ui.ImageVO
import ru.alira.pets.core.util.CFlow
import ru.alira.pets.core.util.wrap
import ru.alira.pets.login.domain.GetLoginHistoryUseCase

interface LoginViewModel {
    val loading: CFlow<Boolean>
    val items: CFlow<List<LoginMessageVO>>
    fun onAnswer()
}

class LoginViewModelImpl constructor(
    private val getLoginHistoryUseCase: GetLoginHistoryUseCase
) : LoginViewModel {

    val _loading = MutableStateFlow(false)
    val _items = MutableStateFlow<List<LoginMessageVO>>(emptyList())

    override val loading: CFlow<Boolean> = _loading.wrap()
    override val items: CFlow<List<LoginMessageVO>> = _items.wrap()

    override fun onAnswer() {

        TODO("Not yet implemented")
    }

    private val viewModelScope = CoroutineScope(Dispatchers.Default)

    init {
        viewModelScope.launch {
            _loading.emit(true)
            val messages = getLoginHistoryUseCase()
            _loading.emit(false)
            messages.forEach { message ->
                _items.getAndUpdate { currentList ->
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