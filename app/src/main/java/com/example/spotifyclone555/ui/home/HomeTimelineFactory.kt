package com.example.spotifyclone555.ui.home

import com.example.spotifyclone555.data.DataC
import com.example.spotifyclone555.model.*

class HomeTimelineFactory {
    companion object{
        fun create():ArrayList<ItemView>{
            val header = ItemView(arrayListOf(Header()),ViewTypes.HOME_HEADER.viewType,"Example Text")

            val albums = DataC.getAlbums()

            val albumView1 = ItemView(arrayListOf(albums[1],albums[2],albums[3]),
                ViewTypes.ALBUM_HORIZONTAL_RECYCLER.viewType,"Jump back in")
            val albumView2 = ItemView(arrayListOf(albums[4],albums[2],albums[9]),
                ViewTypes.ALBUM_HORIZONTAL_RECYCLER.viewType,"Your playlists")
            val albumView3 = ItemView(arrayListOf(albums[7],albums[0],albums[5],albums[8]),
                ViewTypes.ALBUM_HORIZONTAL_RECYCLER.viewType,"Recently played")
            val albumView4 = ItemView(arrayListOf(albums[1],albums[2],albums[3],albums[4],albums[5],albums[6],albums[7],albums[0]),
                ViewTypes.ALBUM_HORIZONTAL_RECYCLER.viewType,"2000's Metal")

            val albumView5 = ItemView(arrayListOf(albums[0],albums[1],albums[2],albums[3],albums[5],albums[6]),
                ViewTypes.ALBUM_SIX_PACK.viewType,"Example Text")

            val blank = ItemView(arrayListOf(),ViewTypes.BLANK.viewType,"Example Text")

            val timeLine = arrayListOf<ItemView>(header,albumView5,albumView1,albumView2,albumView3,albumView4,blank)

            return timeLine
        }
    }
}