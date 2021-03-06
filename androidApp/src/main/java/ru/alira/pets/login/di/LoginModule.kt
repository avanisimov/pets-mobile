package ru.alira.pets.login.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.alira.pets.login.data.LoginDataSourceImpl
import ru.alira.pets.login.data.LoginDataSourceProxy
import ru.alira.pets.login.domain.GetLoginHistoryUseCaseImpl
import ru.alira.pets.login.ui.LoginViewModel
import ru.alira.pets.login.ui.LoginViewModelImpl

@Module
@InstallIn(SingletonComponent::class)
class LoginModule {

    @Provides
    fun bindViewModel(): LoginViewModel {
        return LoginViewModelImpl(
            GetLoginHistoryUseCaseImpl(),
            LoginDataSourceProxy(LoginDataSourceImpl())
        )
    }
}