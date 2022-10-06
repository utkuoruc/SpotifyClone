package com.example.spotifyclone555.viewmodel

import android.app.Application
import android.content.Context
import android.view.View
import androidx.lifecycle.*
import com.example.spotifyclone555.R
import com.example.spotifyclone555.databinding.ActivityMainBinding
import com.example.spotifyclone555.model.Album
import com.example.spotifyclone555.model.Song
import com.google.android.exoplayer2.*
import com.google.android.exoplayer2.source.ClippingMediaSource
import com.google.android.exoplayer2.source.TrackGroupArray
import com.google.android.exoplayer2.trackselection.TrackSelectionArray
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.net.UnknownHostException
import java.util.concurrent.TimeUnit


class MainViewModel(application: Application) : AndroidViewModel(application) {

}