package ru.alira.pets.chat.ui

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ChatListAndroidViewModel @Inject constructor(
    private val viewModel: ChatListViewModel
) : ViewModel(), ChatListViewModel by viewModel {

    override fun onCleared() {
        super.onCleared()
        viewModel.onCleared()
    }
}