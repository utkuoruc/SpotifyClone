package com.example.spotifyclone555.ui.search

import android.graphics.Color
import com.example.spotifyclone555.model.*

class SearchTimelineFactory {
    companion object{
        fun create():ArrayList<ItemView>{
            val header = ItemView(arrayListOf(Header()), ViewTypes.SEARCH_HEADER.viewType,"Search")

            val genre1 = Genre("Rock", Color.rgb(255,0,0),
                "https://i.scdn.co/image/ab67616d00001e0230d45198d0c9e8841f9a9578")
            val genre2 = Genre("Hip-Hop",Color.rgb(135,206,250),
                "https://upload.wikimedia.org/wikipedia/tr/4/42/Relapse_%28album%29.jpg")
            val genre3 = Genre("Pop",Color.rgb(148,0,211),
                "https://upload.wikimedia.org/wikipedia/en/f/f6/Taylor_Swift_-_1989.png")
            val genre4 = Genre("Workout",Color.rgb(0,0,0),
                "https://i.scdn.co/image/ab67616d00001e027614dc8b0eab9abd91cc0d71")
            val genre5 = Genre("Metal",Color.rgb(192,192,192),
                "https://i.scdn.co/image/ab67616d00001e026b3463e7160d333ada4b175a")
            val genre6 = Genre("Punk",Color.rgb(255,0,0),
                "https://i.scdn.co/image/ab67616d00001e021107b18eac8c7824908069cd")
            val genre7 = Genre("Electronic",Color.rgb(255,20,147),
                "https://i.scdn.co/image/ab67616d00001e026aba91ac61162caeeef14460")
            val genre8 = Genre("Stoner",Color.rgb(255,228,181),
                "https://i.scdn.co/image/ab67616d00001e028d6536c65abd7099158ed11b")
            val genre9 = Genre("Emo",Color.rgb(148,0,211),
                "https://i.scdn.co/image/ab67616d00001e02fa4c18fdbd1bf1a39b7b794f")

            val genreView1 = ItemView(arrayListOf(genre1,genre2,genre3,genre4),
                ViewTypes.GENRE_ITEM.viewType,"Your top genres")
            val genreView2 = ItemView(arrayListOf(genre1,genre2,genre3,genre4,genre5,genre6,genre7,genre8),
                ViewTypes.GENRE_ITEM.viewType,"Browse all")

            val blank = ItemView(arrayListOf(),ViewTypes.BLANK.viewType,"Example Text")

            val timeLine = arrayListOf<ItemView>(header,genreView1,genreView2,blank)

            return timeLine
        }
    }
}