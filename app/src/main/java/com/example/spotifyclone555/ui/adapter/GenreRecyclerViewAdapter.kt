package com.example.spotifyclone555.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.spotifyclone555.databinding.BlankItemBinding
import com.example.spotifyclone555.databinding.GenreHeaderBinding
import com.example.spotifyclone555.databinding.RecyclerFrameItemWithTextHorizontalBinding
import com.example.spotifyclone555.databinding.SearchHeaderItemBinding
import com.example.spotifyclone555.model.Album
import com.example.spotifyclone555.model.Genre
import com.example.spotifyclone555.model.ItemView
import com.example.spotifyclone555.model.ViewTypes

class GenreRecyclerViewAdapter(private val itemList: List<ItemView>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    class GenreHeaderViewHolder(val binding: GenreHeaderBinding): RecyclerView.ViewHolder(binding.root){

    }

    class PlaylistListViewHolder(val binding: RecyclerFrameItemWithTextHorizontalBinding): RecyclerView.ViewHolder(binding.root){

    }
    class BlankViewHolder(val binding: BlankItemBinding): RecyclerView.ViewHolder(binding.root){

    }

    override fun getItemViewType(position: Int): Int {
        if(itemList[position].viewType == ViewTypes.GENRE_HEADER.viewType){
            return ViewTypes.GENRE_HEADER.viewType
        }
        else if(itemList[position].viewType == ViewTypes.BLANK.viewType){
            return ViewTypes.BLANK.viewType
        }
        else
            return ViewTypes.ALBUM_GRID_LIST.viewType
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if(viewType == ViewTypes.GENRE_HEADER.viewType){
            val binding = GenreHeaderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            GenreHeaderViewHolder(binding)
        }
        else if(viewType == ViewTypes.BLANK.viewType){
            val binding = BlankItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            BlankViewHolder(binding)
        }
        else{
            val binding = RecyclerFrameItemWithTextHorizontalBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            PlaylistListViewHolder(binding)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder.itemViewType == ViewTypes.GENRE_HEADER.viewType){
            val viewHolder = holder as GenreHeaderViewHolder
            val item = itemList[position]

            holder.binding.genreText.text = item.viewText

            holder.binding.goBack.setOnClickListener {
                Navigation.findNavController(it).popBackStack()
            }
        }
        else if(holder.itemViewType == ViewTypes.BLANK.viewType){

        }
        else{
            val viewHolder = holder as PlaylistListViewHolder
            val item = itemList[position]

            val childLayoutManager = GridLayoutManager(holder.binding.rvChild.context, 2)

            holder.binding.topText.text = item.viewText

            holder.binding.rvChild.apply{
                layoutManager = childLayoutManager
                adapter = AlbumGridListAdapter(item.viewData as List<Album>)
            }
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}