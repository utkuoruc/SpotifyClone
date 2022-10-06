package com.example.spotifyclone555.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import java.time.LocalDateTime

fun ImageView.downloadImage(url: String?){
    //val options = RequestOptions().placeholder(placeholder).error(R.mipmap.ic_launcher_round)

    Glide.with(context).load(url).into(this)
}

@BindingAdapter("android:setImage")
fun setImage(view: ImageView, url: String?){
    view.downloadImage(url)
}

fun getHomeText(): String{
    val current = LocalDateTime.now().hour
    return if(current in 0..4){
        "Good Night"
    }
    else if(current in 5..11){
        "Good Morning"
    }
    else if(current in 12..17){
        "Good Afternoon"
    }
    else{
        "Good Evening"
    }
}