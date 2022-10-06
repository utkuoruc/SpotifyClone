package com.example.spotifyclone555.ui.album

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.spotifyclone555.model.Album
import com.example.spotifyclone555.model.Genre
import com.example.spotifyclone555.model.ItemView
import com.example.spotifyclone555.ui.genre.GenreTimelineFactory
import com.example.spotifyclone555.ui.home.HomeViewModel
import com.example.spotifyclone555.ui.library.LibraryTimelineFactory

class AlbumViewModel :ViewModel() {

    lateinit var timeline: List<ItemView>

    fun createTimeline(album: Album){
        timeline = AlbumTimelineFactory.create(album)
    }
}

class AlbumViewModelFactory(
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AlbumViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return AlbumViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}