package ru.alira.pets.feed.ui

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FeedAndroidViewModel @Inject constructor(
    private val viewModel: FeedViewModel
) : ViewModel(), FeedViewModel by viewModel {

    override fun onCleared() {
        super.onCleared()
        viewModel.onCleared()
    }
}