package com.example.spotifyclone555.ui.genre

import com.example.spotifyclone555.data.DataC
import com.example.spotifyclone555.model.*

class GenreTimelineFactory {
    companion object{
        fun create(genre: Genre):ArrayList<ItemView>{
            val header = ItemView(arrayListOf(Header()), ViewTypes.GENRE_HEADER.viewType,genre.genreName)

            val albums = DataC.getAlbums()

            val albumView1 = ItemView(arrayListOf(albums[1],albums[2],albums[3],albums[4]),
                ViewTypes.ALBUM_GRID_LIST.viewType,"Jump back in")
            val albumView2 = ItemView(arrayListOf(albums[5],albums[6],albums[7],albums[8]),
                ViewTypes.ALBUM_GRID_LIST.viewType,"Your playlists")

            val blank = ItemView(arrayListOf(),ViewTypes.BLANK.viewType,"Example Text")

            val timeLine = arrayListOf<ItemView>(header,albumView1,albumView2,blank)

            return timeLine
        }
    }
}