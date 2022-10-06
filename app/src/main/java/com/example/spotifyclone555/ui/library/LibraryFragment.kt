package com.example.spotifyclone555.ui.library

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.spotifyclone555.databinding.FragmentLibraryBinding
import com.example.spotifyclone555.ui.adapter.LibraryRecyclerViewAdapter
import com.example.spotifyclone555.ui.adapter.SearchRecyclerViewAdapter
import com.example.spotifyclone555.ui.search.SearchViewModel
import com.example.spotifyclone555.ui.search.SearchViewModelFactory

class LibraryFragment : Fragment() {
    private val viewModel: LibraryViewModel by activityViewModels{
        LibraryViewModelFactory(
        )
    }

    private lateinit var recyclerView: RecyclerView
    private var _binding: FragmentLibraryBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentLibraryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        initRecycler()

        return root
    }

    private fun initRecycler() {
        recyclerView = _binding!!.libraryRecyclerView

        recyclerView.apply {
            layoutManager = LinearLayoutManager(activity,
                RecyclerView.VERTICAL, false)

            adapter = LibraryRecyclerViewAdapter(viewModel.timeline)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}