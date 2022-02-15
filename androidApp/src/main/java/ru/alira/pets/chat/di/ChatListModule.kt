package ru.alira.pets.chat.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.alira.pets.chat.ui.ChatListViewModel
import ru.alira.pets.chat.ui.ChatListViewModelImpl

@Module
@InstallIn(SingletonComponent::class)
class ChatListModule {

    @Provides
    fun bindViewModel(): ChatListViewModel {
        return ChatListViewModelImpl(

        )
    }
}