package ru.alira.pets.profile.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.alira.pets.profile.ui.ProfileViewModel
import ru.alira.pets.profile.ui.ProfileViewModelImpl

@Module
@InstallIn(SingletonComponent::class)
class ProfileModule {

    @Provides
    fun bindViewModel(): ProfileViewModel {
        return ProfileViewModelImpl(

        )
    }
}