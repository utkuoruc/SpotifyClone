package com.example.spotifyclone555.ui.library

import com.example.spotifyclone555.data.DataC
import com.example.spotifyclone555.model.*

class LibraryTimelineFactory {
    companion object{
        fun create():ArrayList<ItemView>{

            val libraryHeader = ItemView(arrayListOf(LibraryHeader()),ViewTypes.LIBRARY_HEADER.viewType,"Example Text")

            val filter0 = Filter("Playlists")
            val filter1 = Filter("Artists")
            val filter2 = Filter("Albums")
            val filter3 = Filter("Downloaded")

            val row = ItemView(arrayListOf(LibraryRow()),ViewTypes.LIBRARY_ROW.viewType,"Example Text")

            val filterListView = ItemView(arrayListOf(filter0,filter1,filter2,filter3),ViewTypes.FILTER_LIBRARY.viewType,"Example Text")

            val albums = DataC.getAlbums()

            val albumView1 = ItemView(albums,
                ViewTypes.LIBRARY_ALBUM_LIST_ITEM.viewType,"Example Text")

            val blank = ItemView(arrayListOf(),ViewTypes.BLANK.viewType,"Example Text")

            val timeLine = arrayListOf<ItemView>(libraryHeader,filterListView,row,albumView1,blank)

            return timeLine
        }
    }
}