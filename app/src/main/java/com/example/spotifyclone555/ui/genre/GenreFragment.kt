package com.example.spotifyclone555.ui.genre

import android.graphics.Color
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.spotifyclone555.R
import com.example.spotifyclone555.databinding.FragmentAlbumBinding
import com.example.spotifyclone555.databinding.FragmentGenreBinding
import com.example.spotifyclone555.model.Genre
import com.example.spotifyclone555.ui.adapter.AlbumRecyclerViewAdapter
import com.example.spotifyclone555.ui.adapter.GenreRecyclerViewAdapter
import com.example.spotifyclone555.ui.album.AlbumViewModel
import com.example.spotifyclone555.ui.album.AlbumViewModelFactory

class GenreFragment : Fragment() {
    private val viewModel: GenreViewModel by activityViewModels{
        GenreViewModelFactory(
        )
    }
    private lateinit var recyclerView: RecyclerView
    private var _binding: FragmentGenreBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGenreBinding.inflate(inflater, container, false)
        val root: View = binding.root


        val bundle = arguments
        bundle?.let{
            val args = GenreFragmentArgs.fromBundle(bundle)
            viewModel.createTimeline(args.genre)
        }

        initRecycler()

        return root
    }

    private fun initRecycler() {
        recyclerView = _binding!!.genreRecyclerView

        recyclerView.apply {
            layoutManager = LinearLayoutManager(activity,
                RecyclerView.VERTICAL, false)

            adapter = GenreRecyclerViewAdapter(viewModel.timeline)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}