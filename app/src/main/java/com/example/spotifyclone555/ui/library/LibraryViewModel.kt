package com.example.spotifyclone555.ui.library

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class LibraryViewModel : ViewModel() {
    val timeline = LibraryTimelineFactory.create()
}

class LibraryViewModelFactory(
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LibraryViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return LibraryViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}