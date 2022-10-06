package com.example.spotifyclone555.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.spotifyclone555.databinding.AlbumPreviewItemBinding
import com.example.spotifyclone555.model.Album
import com.example.spotifyclone555.ui.home.HomeFragmentDirections

class AlbumAdapter(private val children : List<Album>): RecyclerView.Adapter<AlbumAdapter.ViewHolder>(){

    class ViewHolder(val binding: AlbumPreviewItemBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): ViewHolder {

        val binding = AlbumPreviewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return children.size
    }

    override fun onBindViewHolder(holder: ViewHolder,
                                  position: Int) {
        val child = children[position]
        //holder.imageView.setImageResource(child.image)
        holder.binding.album = child

        holder.binding.imageView.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToAlbum(child)
            Navigation.findNavController(it).navigate(action)
        }

        //holder.binding.textAlbumName.text = child.albumName
        //ğğholder.binding.textArtistName.text = child.artistName

    }
}