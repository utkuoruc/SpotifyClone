package com.example.spotifyclone555.ui.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.example.spotifyclone555.MainActivity
import com.example.spotifyclone555.databinding.SongListRowBinding
import com.example.spotifyclone555.model.Album

class SongListAdapter(private val album: Album,
                      private val context: Context,
                      private val lifecycleOwner: LifecycleOwner
                      ): RecyclerView.Adapter<SongListAdapter.ViewHolder>() {
    class ViewHolder(val binding: SongListRowBinding): RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = SongListRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var song = album.songList[position]

        holder.binding.song = song

        holder.binding.linearLayoutView.setOnClickListener {
            (context as MainActivity).setPlaylist(album,song)

            (context as MainActivity).play()
        }

        (context as MainActivity).getService().song.observe(lifecycleOwner){
            if(song == it){
                holder.binding.textSongName.setTextColor(Color.GREEN)
            }
            else{
                holder.binding.textSongName.setTextColor(Color.WHITE)
            }
        }


    }

    override fun getItemCount(): Int {
        return album.songList.size
    }

    fun updateUI(){
        //notifyDataSetChanged()
    }
}