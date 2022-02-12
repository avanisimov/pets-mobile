package ru.alira.pets.login.ui

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginAndroidViewModel @Inject constructor(
    private val loginViewModel: LoginViewModel
) : ViewModel(), LoginViewModel by loginViewModel {

    override fun onCleared() {
        super.onCleared()
        loginViewModel.onCleared()
    }
}