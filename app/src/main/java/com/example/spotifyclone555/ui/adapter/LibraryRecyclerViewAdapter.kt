package com.example.spotifyclone555.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.spotifyclone555.databinding.*
import com.example.spotifyclone555.model.*
import kotlin.coroutines.coroutineContext

class LibraryRecyclerViewAdapter(private val itemList: List<ItemView>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    class AlbumViewHolder(val binding: RecyclerFrameItemBinding): RecyclerView.ViewHolder(binding.root){

    }

    class FilterViewHolder(val binding: RecyclerFrameItemHorizontalBinding): RecyclerView.ViewHolder(binding.root){

    }

    class LibraryRowViewHolder(val binding: LibraryChangeLayoutRowBinding): RecyclerView.ViewHolder(binding.root){

    }

    class LibraryHeaderViewHolder(val binding: LibraryHeaderItemBinding): RecyclerView.ViewHolder(binding.root){

    }

    class BlankViewHolder(val binding: BlankItemBinding): RecyclerView.ViewHolder(binding.root){

    }

    override fun getItemViewType(position: Int): Int {
        if(itemList[position].viewType == ViewTypes.LIBRARY_ALBUM_LIST_ITEM.viewType){
            return ViewTypes.LIBRARY_ALBUM_LIST_ITEM.viewType
        }
        else if(itemList[position].viewType == ViewTypes.LIBRARY_ROW.viewType){
            return ViewTypes.LIBRARY_ROW.viewType
        }
        else if(itemList[position].viewType == ViewTypes.LIBRARY_HEADER.viewType){
            return ViewTypes.LIBRARY_HEADER.viewType
        }
        else if(itemList[position].viewType == ViewTypes.BLANK.viewType){
            return ViewTypes.BLANK.viewType
        }
        else
            return ViewTypes.FILTER_LIBRARY.viewType
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if(viewType == ViewTypes.LIBRARY_ALBUM_LIST_ITEM.viewType){
            val binding = RecyclerFrameItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            AlbumViewHolder(binding)
        }
        else if(viewType == ViewTypes.LIBRARY_ROW.viewType){
            val binding = LibraryChangeLayoutRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            LibraryRowViewHolder(binding)
        }
        else if(viewType == ViewTypes.LIBRARY_HEADER.viewType){
            val binding = LibraryHeaderItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            LibraryHeaderViewHolder(binding)
        }
        else if(viewType == ViewTypes.BLANK.viewType){
            val binding = BlankItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            BlankViewHolder(binding)
        }
        else{
            val binding = RecyclerFrameItemHorizontalBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            FilterViewHolder(binding)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder.itemViewType == ViewTypes.LIBRARY_ALBUM_LIST_ITEM.viewType){
            val viewHolder = holder as AlbumViewHolder
            val item = itemList[position].viewData

            val childLayoutManager = LinearLayoutManager(holder.binding.rvChild.context, RecyclerView.VERTICAL, false)

            holder.binding.rvChild.apply{
                layoutManager = childLayoutManager
                adapter = AlbumListAdapter(item as List<Album>)
            }
        }
        else if(holder.itemViewType == ViewTypes.LIBRARY_ROW.viewType){
            val viewHolder = holder as LibraryRowViewHolder
            val item = itemList[position].viewData as ArrayList<LibraryRow>

            //holder.binding.welcomeText.text = item.get(0).message
        }
        else if(holder.itemViewType ==  ViewTypes.LIBRARY_HEADER.viewType){
            val viewHolder = holder as LibraryHeaderViewHolder
            val item = itemList[position].viewData as ArrayList<LibraryHeader>
        }
        else if(holder.itemViewType == ViewTypes.BLANK.viewType){

        }
        else{
            val viewHolder = holder as FilterViewHolder
            val item = itemList[position].viewData

            val childLayoutManager = LinearLayoutManager(holder.binding.rvChild.context, RecyclerView.HORIZONTAL, false)

            holder.binding.rvChild.apply{
                layoutManager = childLayoutManager
                adapter = FilterAdapter(item as List<Filter>)
            }

        }

    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}