package com.example.spotifyclone555.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Song(
    val queue: Int,
    val albumName: String,
    val artistName: String,
    val songName: String,
    val songSource: String,
    val imageSource: String
): Parcelable