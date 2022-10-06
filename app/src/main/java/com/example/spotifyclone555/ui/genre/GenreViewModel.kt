package com.example.spotifyclone555.ui.genre

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.spotifyclone555.model.Genre
import com.example.spotifyclone555.model.ItemView
import com.example.spotifyclone555.ui.album.AlbumTimelineFactory
import com.example.spotifyclone555.ui.home.HomeViewModel

class GenreViewModel: ViewModel() {
    lateinit var timeline: List<ItemView>

    fun createTimeline(genre: Genre){
        timeline = GenreTimelineFactory.create(genre)
    }

    //val timeline = GenreTimelineFactory.create()

    private val _genre = MutableLiveData<Genre>()

    val genre: LiveData<Genre> = _genre

}
class GenreViewModelFactory(
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GenreViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return GenreViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}