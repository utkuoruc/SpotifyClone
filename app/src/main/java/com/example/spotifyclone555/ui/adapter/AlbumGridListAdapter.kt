package com.example.spotifyclone555.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.spotifyclone555.databinding.AlbumPreviewItemBinding
import com.example.spotifyclone555.model.Album
import com.example.spotifyclone555.ui.genre.GenreFragmentDirections
import com.example.spotifyclone555.ui.home.HomeFragmentDirections

class AlbumGridListAdapter(private val albumList : List<Album>): RecyclerView.Adapter<AlbumGridListAdapter.ViewHolder>() {

    class ViewHolder(val binding: AlbumPreviewItemBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumGridListAdapter.ViewHolder {
        val binding = AlbumPreviewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val album = albumList[position]
        //holder.imageView.setImageResource(child.image)
        holder.binding.album = album

        holder.binding.imageView.setOnClickListener {
            val action = GenreFragmentDirections.actionGenreFragmentToAlbum(album)
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return albumList.size
    }

}