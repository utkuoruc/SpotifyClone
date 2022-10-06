package com.example.spotifyclone555.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.spotifyclone555.databinding.AlbumPackRowBinding
import com.example.spotifyclone555.databinding.AlbumPreviewItemBinding
import com.example.spotifyclone555.model.Album
import com.example.spotifyclone555.ui.home.HomeFragmentDirections

class SixPackAdapter(private val albumList : List<Album>): RecyclerView.Adapter<SixPackAdapter.ViewHolder>() {

    class ViewHolder(val binding: AlbumPackRowBinding): RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = AlbumPackRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var album = albumList[position]

        holder.binding.album = album
        //holder.binding.textAlbumName.text = album.albumName

        holder.binding.cardView.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToAlbum(album)
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return albumList.size
    }
}