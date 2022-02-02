package ru.alira.pets.login.ui

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginAndroidViewModel @Inject constructor(
    loginViewModel: LoginViewModel
) : ViewModel(), LoginViewModel by loginViewModel {

}