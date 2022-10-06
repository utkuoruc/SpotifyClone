package com.example.spotifyclone555.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.spotifyclone555.databinding.AlbumPreviewItemBinding
import com.example.spotifyclone555.databinding.FilterRowBinding
import com.example.spotifyclone555.model.Album
import com.example.spotifyclone555.model.Filter

class FilterAdapter(private val filterList: List<Filter>): RecyclerView.Adapter<FilterAdapter.ViewHolder>() {
    class ViewHolder(val binding: FilterRowBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = FilterRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = filterList[position]

        holder.binding.filterName.text = item.filterName
    }

    override fun getItemCount(): Int {
        return filterList.size
    }
}