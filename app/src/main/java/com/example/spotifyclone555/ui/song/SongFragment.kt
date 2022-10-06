package com.example.spotifyclone555.ui.song

import android.os.Bundle
import android.transition.TransitionInflater
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.activity.addCallback
import androidx.activity.viewModels
import androidx.core.util.TimeUtils.formatDuration
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.spotifyclone555.MainActivity
import com.example.spotifyclone555.R
import com.example.spotifyclone555.databinding.FragmentSongBinding
import com.example.spotifyclone555.service.MusicService
import com.example.spotifyclone555.ui.home.HomeFragmentDirections
import com.example.spotifyclone555.util.downloadImage
import com.example.spotifyclone555.util.setImage
import com.example.spotifyclone555.viewmodel.MainViewModel
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player

class SongFragment : Fragment() {

    private val mainViewModel: MainViewModel by activityViewModels()

    private lateinit var mService: MusicService
    private var _binding: FragmentSongBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val inflater = TransitionInflater.from(requireContext())
        enterTransition = inflater.inflateTransition(R.transition.slide_up)
        exitTransition = inflater.inflateTransition(R.transition.slide_up)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSongBinding.inflate(inflater, container, false)
        val root: View = binding.root

        //mainViewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)

        mService = (context as MainActivity).getService()

        binding.service = mService

        subscribeToObservables()

        mService.setSnackbar(false)

        binding.collapse.setOnClickListener {
            Navigation.findNavController(it).popBackStack()
        }

        binding.play.setOnClickListener {
            mService.playPause()
        }

        binding.skipNext.setOnClickListener {
            mService.skipNext()
        }

        binding.skipPrevious.setOnClickListener {
            mService.skipPrevious()
        }

        binding.nowPlayingAlbumButton.setOnClickListener {
            val action = SongFragmentDirections.actionSongFragmentToAlbum(mService.album.value!!)
            Navigation.findNavController(it).navigate(action)
        }

        binding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                (activity as MainActivity).progressChanged(progress,fromUser)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                //player?.seekTo((seekBar.progress * 1000).toLong())
            }
        })


        //what happens when back button is pressed
        val callback = requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            findNavController().popBackStack()
        }

        return root
    }

    private fun subscribeToObservables(){

        mService.isSongPlaying.observe(viewLifecycleOwner){
            binding.play.setImageResource(
                if(it) R.drawable.ic_baseline_pause_24 else R.drawable.ic_baseline_play_arrow_24
            )
        }

        mService.song.observe(viewLifecycleOwner){
            binding.song = it
        }

        mService.currentSongDurationInText.observe(viewLifecycleOwner){
            binding.songDuration.text = it
        }

        mService.currentSongDuration.observe(viewLifecycleOwner){
            binding.seekBar.max = it.toInt()
        }

        mService.currentProgress.observe(viewLifecycleOwner){
            binding.seekBar.progress = it.toInt()
            binding.currentState.text = mService.formatTime(it)
        }
    }

    override fun onDestroy() {
        mService.setSnackbar(true)
        super.onDestroy()
    }
}