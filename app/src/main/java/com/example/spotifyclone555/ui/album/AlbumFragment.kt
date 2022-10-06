package com.example.spotifyclone555.ui.album

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.spotifyclone555.MainActivity
import com.example.spotifyclone555.R
import com.example.spotifyclone555.databinding.ActivityAuthBinding
import com.example.spotifyclone555.databinding.ActivityMainBinding
import com.example.spotifyclone555.databinding.FragmentAlbumBinding
import com.example.spotifyclone555.model.Album
import com.example.spotifyclone555.service.MusicService
import com.example.spotifyclone555.ui.adapter.AlbumRecyclerViewAdapter
import com.example.spotifyclone555.ui.genre.GenreFragmentArgs
import com.example.spotifyclone555.ui.home.HomeViewModel
import com.example.spotifyclone555.viewmodel.MainViewModel

class AlbumFragment : Fragment() {

    private val viewModel: AlbumViewModel by activityViewModels{
        AlbumViewModelFactory(
        )
    }

    private lateinit var mService: MusicService

    private val mainViewModel: MainViewModel by activityViewModels()

    private lateinit var albumRecyclerViewAdapter: AlbumRecyclerViewAdapter
    private lateinit var recyclerView: RecyclerView
    private var _binding: FragmentAlbumBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var album: Album

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentAlbumBinding.inflate(inflater, container, false)
        val root: View = binding.root

        //mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        mService = (context as MainActivity).getService()

        val bundle = arguments
        bundle?.let{
            val args = AlbumFragmentArgs.fromBundle(bundle)
            album = args.album
            viewModel.createTimeline(album)
        }

        initRecycler()

        subscribeToObservables()

        return root
    }

    private fun initRecycler() {
        recyclerView = _binding!!.albumRecyclerView

        recyclerView.apply {
            layoutManager = LinearLayoutManager(activity,
                RecyclerView.VERTICAL, false)

            albumRecyclerViewAdapter = AlbumRecyclerViewAdapter(viewModel.timeline, context, album, viewLifecycleOwner)

            adapter = albumRecyclerViewAdapter
        }
    }

    private fun subscribeToObservables(){
        mService.isSongPlaying.observe(viewLifecycleOwner){
            albumRecyclerViewAdapter.updateUI(it)
        }
    }
}