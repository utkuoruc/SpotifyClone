package com.example.spotifyclone555.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.spotifyclone555.databinding.*
import com.example.spotifyclone555.model.*

class SearchRecyclerViewAdapter(private val itemList: List<ItemView>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class GenresViewHolder(val binding: RecyclerFrameItemWithTextHorizontalBinding): RecyclerView.ViewHolder(binding.root){

    }

    class SearchHeaderViewHolder(val binding: SearchHeaderItemBinding): RecyclerView.ViewHolder(binding.root){

    }

    class BlankViewHolder(val binding: BlankItemBinding): RecyclerView.ViewHolder(binding.root){

    }

    override fun getItemViewType(position: Int): Int {
        if(itemList[position].viewType == ViewTypes.SEARCH_HEADER.viewType){
            return ViewTypes.SEARCH_HEADER.viewType
        }
        else if(itemList[position].viewType == ViewTypes.BLANK.viewType){
            return ViewTypes.BLANK.viewType
        }
        else
            return ViewTypes.GENRE_ITEM.viewType
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if(viewType == ViewTypes.SEARCH_HEADER.viewType){
            val binding = SearchHeaderItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            SearchHeaderViewHolder(binding)
        }
        else if(viewType == ViewTypes.BLANK.viewType){
            val binding = BlankItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            BlankViewHolder(binding)
        }
        else{
            val binding = RecyclerFrameItemWithTextHorizontalBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            GenresViewHolder(binding)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder.itemViewType == ViewTypes.SEARCH_HEADER.viewType){
            val viewHolder = holder as SearchHeaderViewHolder
            val item = itemList[position].viewData
        }
        else if(holder.itemViewType == ViewTypes.BLANK.viewType){

        }
        else{
            val viewHolder = holder as GenresViewHolder
            val item = itemList[position]

            val childLayoutManager = GridLayoutManager(holder.binding.rvChild.context, 2)

            holder.binding.topText.text = item.viewText

            holder.binding.rvChild.apply{
                layoutManager = childLayoutManager
                adapter = GenreListAdapter(item.viewData as List<Genre>)
            }
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}