package com.example.spotifyclone555.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class Album(
    val albumName: String,
    val artistName: String,
    val imageSource: String,
    val songList: List<Song>
): Parcelable