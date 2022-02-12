package ru.alira.pets.profile.ui

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileAndroidViewModel @Inject constructor(
    private val viewModel: ProfileViewModel
) : ViewModel(), ProfileViewModel by viewModel {

    override fun onCleared() {
        super.onCleared()
        viewModel.onCleared()
    }
}