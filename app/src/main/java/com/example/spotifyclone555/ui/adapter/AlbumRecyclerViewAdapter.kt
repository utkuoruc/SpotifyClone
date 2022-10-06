package com.example.spotifyclone555.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.spotifyclone555.MainActivity
import com.example.spotifyclone555.R
import com.example.spotifyclone555.databinding.*
import com.example.spotifyclone555.model.*

class AlbumRecyclerViewAdapter(private val itemList: List<ItemView>,
                               private val context: Context,
                               private val album: Album,
                               private val lifecycleOwner: LifecycleOwner
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class SongListViewHolder(val binding: RecyclerFrameItemBinding): RecyclerView.ViewHolder(binding.root){

    }
    class PlayListHeaderViewHolder(val binding: PlaylistHeaderItemBinding): RecyclerView.ViewHolder(binding.root){
    }
    class BlankViewHolder(val binding: BlankItemBinding): RecyclerView.ViewHolder(binding.root){

    }

    private var header: PlayListHeaderViewHolder? = null

    private var songListAdapter: SongListAdapter? = null

    override fun getItemViewType(position: Int): Int {
        if(itemList[position].viewType == ViewTypes.ALBUM.viewType){
            return ViewTypes.ALBUM.viewType
        }
        else if(itemList[position].viewType == ViewTypes.PLAYLIST_HEADER.viewType){
            return ViewTypes.PLAYLIST_HEADER.viewType
        }
        else if(itemList[position].viewType == ViewTypes.BLANK.viewType){
            return ViewTypes.BLANK.viewType
        }
        else
            return ViewTypes.FILTER_LIBRARY.viewType
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if(viewType == ViewTypes.ALBUM.viewType){
            val binding = RecyclerFrameItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            SongListViewHolder(binding)
        }
        else if(viewType == ViewTypes.PLAYLIST_HEADER.viewType){
            val binding = PlaylistHeaderItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            header = PlayListHeaderViewHolder(binding)
            header!!
        }
        else if(viewType == ViewTypes.BLANK.viewType){
            val binding = BlankItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            BlankViewHolder(binding)
        }
        else{
            val binding = PlaylistHeaderItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            PlayListHeaderViewHolder(binding)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder.itemViewType == ViewTypes.ALBUM.viewType){
            val viewHolder = holder as SongListViewHolder
            val item = itemList[position].viewData

            val childLayoutManager = LinearLayoutManager(holder.binding.rvChild.context, RecyclerView.VERTICAL, false)

            holder.binding.rvChild.apply{
                layoutManager = childLayoutManager
                songListAdapter = SongListAdapter(album, context, lifecycleOwner)
                adapter = songListAdapter
            }

        }
        else if(holder.itemViewType == ViewTypes.PLAYLIST_HEADER.viewType){

            val viewHolder = holder as PlayListHeaderViewHolder

            holder.binding.album = album

            holder.binding.goBack.setOnClickListener {
                Navigation.findNavController(it).popBackStack()
            }

            if((context as MainActivity).getService().album.value == album){
                if((context).getService().isSongPlaying.value!!){
                    header!!.binding.playPause.setImageResource(R.drawable.ic_baseline_pause_circle_filled_24)
                } else{
                    header!!.binding.playPause.setImageResource(R.drawable.ic_baseline_play_circle_filled_24)
                }
            }


            holder.binding.playPause.setOnClickListener {

                if((context as MainActivity).getService().getIsQueue()){
                    if((context as MainActivity).getService().album.value == album){
                        (context as MainActivity).playPause()
                    }
                    else{
                        (context as MainActivity).setPlaylist(album,album.songList[0])

                        (context as MainActivity).play()
                    }
                }
                else{
                    //first time clicking
                    (context as MainActivity).setPlaylist(album,album.songList[0])

                    (context as MainActivity).play()
                }
            }


        }
        else if(holder.itemViewType == ViewTypes.BLANK.viewType){

        }
        else{

        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    fun updateUI(isPlaying: Boolean){
        header?.let{
            header!!.binding.playPause.setImageResource(
                if(isPlaying) R.drawable.ic_baseline_pause_circle_filled_24 else R.drawable.ic_baseline_play_circle_filled_24
            )
        }
        songListAdapter?.let{
            songListAdapter!!.updateUI()
        }

    }

}