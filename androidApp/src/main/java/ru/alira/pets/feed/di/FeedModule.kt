package ru.alira.pets.feed.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.alira.pets.feed.ui.FeedViewModel
import ru.alira.pets.feed.ui.FeedViewModelImpl

@Module
@InstallIn(SingletonComponent::class)
class FeedModule {

    @Provides
    fun bindViewModel(): FeedViewModel {
        return FeedViewModelImpl(

        )
    }
}