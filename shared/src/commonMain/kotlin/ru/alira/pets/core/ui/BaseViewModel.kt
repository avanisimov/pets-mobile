package ru.alira.pets.core.ui

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

interface Clearable {
    fun onCleared()
}

open class BaseViewModel : Clearable {

    private val viewModelScope = CoroutineScope(Dispatchers.Default)

    protected fun launch(block: suspend CoroutineScope.() -> Unit) {
        viewModelScope.launch {
            try {
                block()
            } catch (e: Exception) {
                println(e.message)
                e.printStackTrace()
            }
        }
    }

    override fun onCleared() {
        viewModelScope.cancel()
    }
}