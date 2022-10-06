package com.example.spotifyclone555

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.spotifyclone555.databinding.ActivityMainBinding
import com.example.spotifyclone555.model.Album
import com.example.spotifyclone555.model.Song
import com.example.spotifyclone555.service.MusicService
import com.example.spotifyclone555.viewmodel.MainViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    private lateinit var mService: MusicService

    private var mBound: Boolean = false

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Hide Action Bar Programmatically
        supportActionBar?.hide()

        val navView: BottomNavigationView = binding.navView

        navController = findNavController(R.id.nav_host_fragment_activity_main)

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.home, R.id.search, R.id.library, R.id.song
            )
        )

        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        //viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.lifecycleOwner = this

        val intent = Intent(this, MusicService::class.java)

        if(MusicService.isRunning){
            println("service was running")

            bindService(intent, connection, BIND_AUTO_CREATE)
        }
        else{
            println("service was not running")
            //startForegroundService(intent)
            startService(intent)

            bindService(intent, connection, 0)
        }

        binding.cardView.setOnClickListener {
            navController.navigate(R.id.song)
        }

        binding.playPause.setOnClickListener {
            mService.playPause()

            //observeChanges(binding,viewModel,this)
        }


        //binding.notifyChange()
        println("onCreate called")
    }

    override fun onResume() {
        super.onResume()

        println("onResume called")
    }

    override fun onStop() {
        super.onStop()

        println("onStop called")
    }

    private val connection = object : ServiceConnection {
        override fun onServiceConnected(className: ComponentName, service: IBinder
        ) {
            println("onServiceConnected")
            val binder = service as MusicService.LocalBinder

            mService = binder.getService()

            mBound = true

            binding.service = mService

            subscribeToObservables()
        }

        override fun onServiceDisconnected(name: ComponentName) {
            println("onServiceDisconnected")
            mBound = false
        }
    }

    override fun onStart() {
        super.onStart()

        println("onStart called")
    }

    override fun onRestart() {
        super.onRestart()
        println("onRestart called")
    }

    override fun onPause() {
        super.onPause()
        println("onPause called")
    }

    override fun onDestroy() {
        println("onDestroy called")

        unbindService(connection)

        super.onDestroy()
    }

    fun play(){
        mService.play()
    }

    fun getService(): MusicService{
        return mService
    }

    fun playPause(){
        if(mService.isPlaying())
            pause()
        else
            play()
    }

    fun pause(){
        mService.pause()
    }

    fun skipNext(){
        mService.skipNext()
    }

    fun skipPrevious(){
        mService.skipPrevious()
    }

    //viewmodel (call to service?)
    fun progressChanged(progress: Int, fromUser: Boolean){
        mService.progressChanged(progress,fromUser)
    }

    //viewmodel (call to service?)
    fun setPlaylist(album: Album, song: Song){
        mService.setPlaylist(album,song)
    }

    private fun subscribeToObservables(){
        mService.isSongPlaying.observe(this){
            binding.playPause.setImageResource(
                if(it) R.drawable.ic_baseline_pause_24 else R.drawable.ic_baseline_play_arrow_24
            )
            //mService.setSnackbar(it)
        }

        mService.snackbarVisible.observe(this){
            if(it){
                binding.cardView.visibility = View.VISIBLE
            }
            else
                binding.cardView.visibility = View.GONE
        }

        mService.errorViewVisible.observe(this){
            if(it){
                binding.errorView.visibility = View.VISIBLE
            }
            else
                binding.errorView.visibility = View.GONE
        }

        mService.errorViewText.observe(this){
            binding.errorText.text = it
        }
    }
}