package com.example.spotifyclone555.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.spotifyclone555.databinding.GenresRowBinding
import com.example.spotifyclone555.model.Genre
import com.example.spotifyclone555.ui.search.SearchFragmentDirections

class GenreListAdapter(private val genreList: List<Genre>): RecyclerView.Adapter<GenreListAdapter.ViewHolder>() {

    class ViewHolder(val binding: GenresRowBinding): RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = GenresRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = genreList[position]

        holder.binding.genre = data

        holder.binding.textGenre.text = data.genreName

        holder.binding.cardView.setCardBackgroundColor(data.genreColor)

        holder.binding.cardView.setOnClickListener {
             val action = SearchFragmentDirections.actionSearchFragmentToGenre(data)
             Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return genreList.size
    }
}