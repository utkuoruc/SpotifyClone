package com.example.spotifyclone555.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.spotifyclone555.databinding.*
import com.example.spotifyclone555.model.Album
import com.example.spotifyclone555.model.ItemView
import com.example.spotifyclone555.model.ViewTypes
import com.example.spotifyclone555.util.getHomeText

class HomeRecyclerViewAdapter(private val itemList: ArrayList<ItemView>):  RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class AlbumSixPackViewHolder(val binding: RecyclerFrameItemHorizontalBinding): RecyclerView.ViewHolder(binding.root){

    }

    class AlbumHorizontalRecyclerViewHolder(val binding: RecyclerFrameItemWithTextHorizontalBinding): RecyclerView.ViewHolder(binding.root){

    }

    class HomeHeaderViewHolder(val binding: HomeHeaderItemBinding): RecyclerView.ViewHolder(binding.root){

    }

    class BlankViewHolder(val binding: BlankItemBinding): RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if(viewType == ViewTypes.ALBUM_SIX_PACK.viewType){
            val binding = RecyclerFrameItemHorizontalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            AlbumSixPackViewHolder(binding)
        }
        else if(viewType == ViewTypes.HOME_HEADER.viewType){
            val binding = HomeHeaderItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            HomeHeaderViewHolder(binding)
        }
        else if(viewType == ViewTypes.BLANK.viewType){
            val binding = BlankItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            BlankViewHolder(binding)
        }
        else{
            val binding = RecyclerFrameItemWithTextHorizontalBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            AlbumHorizontalRecyclerViewHolder(binding)
        }
    }

    override fun getItemViewType(position: Int): Int {
        if(itemList[position].viewType == ViewTypes.ALBUM_SIX_PACK.viewType){
            return ViewTypes.ALBUM_SIX_PACK.viewType
        }
        else if(itemList[position].viewType == ViewTypes.HOME_HEADER.viewType){
            return ViewTypes.HOME_HEADER.viewType
        }
        else if(itemList[position].viewType == ViewTypes.BLANK.viewType){
            return ViewTypes.BLANK.viewType
        }
        else
            return ViewTypes.ALBUM_HORIZONTAL_RECYCLER.viewType
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder.itemViewType == ViewTypes.ALBUM_SIX_PACK.viewType){
            val viewHolder = holder as AlbumSixPackViewHolder
            val item = itemList[position].viewData
            //viewHolder.binding.imageAlbumCover

            val childLayoutManager = GridLayoutManager(holder.binding.rvChild.context, 2)
            holder.binding.rvChild.apply{
                layoutManager = childLayoutManager
                adapter = SixPackAdapter(item as List<Album>)
            }

        }
        else if(holder.itemViewType == ViewTypes.HOME_HEADER.viewType){
            val viewHolder = holder as HomeHeaderViewHolder
            val item = itemList[position].viewData

            holder.binding.welcomeText.text = getHomeText()


            holder.binding.notificationsBell.setOnClickListener {
                //open notifications fragment
            }

            holder.binding.recentActivities.setOnClickListener {
                //open recent activities fragment
            }

            holder.binding.settings.setOnClickListener {
                //open settings fragment
            }
        }
        else if(holder.itemViewType == ViewTypes.BLANK.viewType){

        }
        else{
            val viewHolder = holder as AlbumHorizontalRecyclerViewHolder
            val item = itemList[position]

            val childLayoutManager = LinearLayoutManager(holder.binding.rvChild.context, RecyclerView.HORIZONTAL, false)

            holder.binding.topText.text = item.viewText
            holder.binding.rvChild.apply{
                layoutManager = childLayoutManager
                adapter = AlbumAdapter(item.viewData as List<Album>)
            }
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }


}