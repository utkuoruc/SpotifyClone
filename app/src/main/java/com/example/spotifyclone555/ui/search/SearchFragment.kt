package com.example.spotifyclone555.ui.search

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
import com.example.spotifyclone555.databinding.FragmentSearchBinding
import com.example.spotifyclone555.ui.adapter.SearchRecyclerViewAdapter

class SearchFragment : Fragment() {
    private val viewModel: SearchViewModel by activityViewModels{
        SearchViewModelFactory(
        )
    }
    private lateinit var recyclerView: RecyclerView
    private var _binding: FragmentSearchBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(SearchViewModel::class.java)

        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        val root: View = binding.root

        initRecycler()

        return root
    }

    private fun initRecycler() {
        recyclerView = _binding!!.searchRecyclerView

        recyclerView.apply {
            layoutManager = LinearLayoutManager(activity,
                RecyclerView.VERTICAL, false)

            adapter = SearchRecyclerViewAdapter(viewModel.timeline)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}