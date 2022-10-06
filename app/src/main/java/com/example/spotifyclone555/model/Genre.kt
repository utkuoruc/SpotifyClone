package com.example.spotifyclone555.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Genre(
    val genreName: String,
    val genreColor: Int,
    val genreImage: String
): Parcelable