package com.example.spotifyclone555.service

import android.app.*
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Binder
import android.os.IBinder
import androidx.core.app.NotificationCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.example.spotifyclone555.MainActivity
import com.example.spotifyclone555.R
import com.example.spotifyclone555.model.Album
import com.example.spotifyclone555.model.Song
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.PlaybackException
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.ui.PlayerNotificationManager
import kotlinx.coroutines.*
import java.util.concurrent.TimeUnit
import kotlin.system.exitProcess


class MusicService: Service() {

    private val _song = MutableLiveData<Song>()
    val song: LiveData<Song> = _song

    private val _currentSongDuration = MutableLiveData<Long>()
    val currentSongDuration: LiveData<Long> = _currentSongDuration

    private val _currentSongDurationInText = MutableLiveData<String>()
    val currentSongDurationInText: LiveData<String> = _currentSongDurationInText

    private val _playlist = MutableLiveData<List<Song>>()
    val playlist: LiveData<List<Song>> = _playlist

    private val _album = MutableLiveData<Album>()
    val album: LiveData<Album> = _album

    private val _snackbarVisible = MutableLiveData<Boolean>(false)
    val snackbarVisible: LiveData<Boolean> = _snackbarVisible

    private val _errorViewVisible = MutableLiveData<Boolean>(false)
    val errorViewVisible: LiveData<Boolean> = _errorViewVisible

    private val _errorViewText = MutableLiveData<String>()
    val errorViewText: LiveData<String> = _errorViewText

    private val _isSongPlaying = MutableLiveData<Boolean>(false)
    val isSongPlaying: LiveData<Boolean> = _isSongPlaying

    private val _currentProgress = MutableLiveData<Long>(0)
    val currentProgress: LiveData<Long> = _currentProgress

    private val _playerState = MutableLiveData<Int>()
    val playerState: LiveData<Int> = _playerState

    // Binder given to clients
    private val binder = LocalBinder()

    private var player: ExoPlayer? = null

    private lateinit var playerNotificationManager: PlayerNotificationManager
    private lateinit var playerNotification: PlayerNotificationManager.Builder

    private val serviceJob = Job()
    private val serviceScope = CoroutineScope(Dispatchers.Main + serviceJob)

    private val notificationId = 4131

    private var firstSet = false

    var notification : Notification ?= null

    companion object{
        var isRunning: Boolean = false
    }

    inner class LocalBinder: Binder(){
        fun getService(): MusicService{
            return this@MusicService
        }
    }

    override fun onCreate() {
        super.onCreate()
        println("onCreate in MusicService")

        isRunning = true
        initializePlayer()

        /*
        val channel1 = NotificationChannel("channel1", "Channel 1", NotificationManager.IMPORTANCE_DEFAULT)
        val notificationManager = getSystemService(NotificationManager::class.java)
        channel1.setSound(null, null)
        notificationManager.createNotificationChannel(channel1)

        registerReceiver(broadcastReceiver, IntentFilter("ACTION"))
        createNotification("idle")
         */

        playerNotification = PlayerNotificationManager.Builder(this@MusicService,notificationId,getChannelId())
            .setMediaDescriptionAdapter(descriptionAdapter)

        playerNotificationManager = playerNotification.build()

        playerNotificationManager.setUseStopAction(false)
        playerNotificationManager.setUsePlayPauseActions(true)
        playerNotificationManager.setUseNextAction(true)
        playerNotificationManager.setUsePreviousAction(true)
        playerNotificationManager.setUseChronometer(true)
        playerNotificationManager.setPlayer(player)
        playerNotificationManager.setUseFastForwardAction(false)
        playerNotificationManager.setUsePreviousActionInCompactView(true)
        playerNotificationManager.setUseNextActionInCompactView(true)
        playerNotificationManager.setUseRewindAction(false)
        playerNotificationManager.setUseRewindActionInCompactView(false)

        /*
        _song.observe(this){
            if(it != null){
                val notification = NotificationCompat.Builder(this@MusicService, getChannelId()).build()
                this.startForeground(notificationId, notification)
            }
        }
        */
    }
    /*
    val notificationListener = object: PlayerNotificationManager.NotificationListener{
        override fun onNotificationCancelled(notificationId: Int, dismissedByUser: Boolean) {
            super.onNotificationCancelled(notificationId, dismissedByUser)
        }
    }
    */

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return START_NOT_STICKY
    }

    override fun onTaskRemoved(rootIntent: Intent?) {
        println("beat da fuck out of the store owner")
        player?.let{
            player!!.pause()
        }
        //stopForeground(STOP_FOREGROUND_REMOVE)
        val intent = Intent(this, MusicService::class.java)

        stopForeground(STOP_FOREGROUND_REMOVE)
        //stopService(intent)
        stopSelf()
        super.onTaskRemoved(rootIntent)
        exitProcess(0)

        //stopSelf()
    }

    override fun onDestroy() {
        /*
             When a service is no longer in use, the system invokes this method

             just before the service destroys as a final clean up call. Services must

             implement this method in order to clean up resources like registered listeners,

             threads, receivers, etc.
        */
        println("onDestroy in MusicService")
        releasePlayer()
        isRunning = false
        stopSelf()

        notification = null

        super.onDestroy()
        exitProcess(0)
    }

    fun buildNotification(){
        if(notification == null){
            println("notification build")
            notification = NotificationCompat.Builder(this@MusicService, getChannelId()).build()
            this.startForeground(notificationId, notification)
        }
    }

    override fun onBind(intent: Intent): IBinder {
        return binder
    }

    private fun getChannelId(): String {
        return createNotificationChannel("spotify_clone", "SpotifyClone555")
    }

    @Suppress("SameParameterValue")
    private fun createNotificationChannel(channelId: String, channelName: String): String{
        val chan = NotificationChannel(
            channelId,
            channelName, NotificationManager.IMPORTANCE_NONE
        )
        chan.lightColor = Color.BLUE
        chan.lockscreenVisibility = Notification.VISIBILITY_PRIVATE
        val service = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        service.createNotificationChannel(chan)
        return channelId
    }

    val descriptionAdapter = object : PlayerNotificationManager.MediaDescriptionAdapter {

        override fun getCurrentContentTitle(player: Player): String = _song.value?.songName?:""

        override fun getCurrentContentText(player: Player): String = _song.value?.albumName?:""

        override fun getCurrentLargeIcon(player: Player, callback: PlayerNotificationManager.BitmapCallback) = getCurrentLargeIcon()

        fun getCurrentLargeIcon(): Bitmap? {
            var myBitmap: Bitmap? = BitmapFactory.decodeResource(resources, R.drawable.queens_of_the_stone_age_lullabies_to_paralyze)

            Glide.with(this@MusicService)
                .asBitmap()
                .load(_song.value?.songSource ?: "https://cdn.webrazzi.com/uploads/2015/09/google-logo.png")
                .into(object : CustomTarget<Bitmap>(){
                    override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                        myBitmap = resource
                    }
                    override fun onLoadCleared(placeholder: Drawable?) {
                        // this is called when imageView is cleared on lifecycle call or for
                        // some other reason.
                        // if you are referencing the bitmap somewhere else too other than this imageView
                        // clear it here as you can no longer have the bitmap
                    }
                })

            return myBitmap
        }

        override fun createCurrentContentIntent(player: Player): PendingIntent? {

            val notificationIntent = Intent(this@MusicService, MainActivity::class.java)

            return PendingIntent.getActivity(this@MusicService, 0, notificationIntent, 0)
        }
    }

    fun isPlaying(): Boolean{
        return player!!.isPlaying
    }

    fun resume(){
        player?.let {
            play()
        }
    }

    fun playPause(){
        if(_isSongPlaying.value!!)
            pause()
        else
            resume()
    }

    fun pause(){
        player?.let {
            player!!.pause()
        }
    }

    fun play(){
        if(!firstSet){
            firstSet = true
            buildNotification()
            println("hey")
        }
        player?.let{
            if(!player!!.isPlaying)
                player!!.play()
        }
    }

    fun skipNext(){
        player!!.seekToNextMediaItem()

        /*
        if(_song.value!!.queue < _playlist.value!!.size)
            _song.value = _playlist.value!!.get(player!!.currentMediaItemIndex)

         */
    }

    fun skipPrevious(){
        player!!.seekToPrevious()

        /*
        if(_song.value!!.queue != 0)
            _song.value = _playlist.value!!.get(player!!.currentMediaItemIndex)

         */
    }

    fun progressChanged(progress: Int, fromUser: Boolean){
        if(fromUser) {
            player!!.seekTo(progress.toLong())
        }
    }

    fun setSong(songItem: Song){
        _song.value = songItem

        _snackbarVisible.value = true
    }

    fun setPlaylist(album: Album, song: Song){
        player!!.clearMediaItems()

        _playlist.value = album.songList
        _album.value = album

        for(track in _playlist.value!!){
            val mediaItem = MediaItem.fromUri(track.songSource)
            player!!.addMediaItem(mediaItem)
        }

        player!!.seekToDefaultPosition(song.queue)
        setSong(song)
    }

    fun initializePlayer() {
        player = ExoPlayer.Builder(this)
            .build()
            .also { exoPlayer ->
                exoPlayer.prepare()
            }

        player!!.addListener(
            object : Player.Listener {
                override fun onMediaItemTransition(mediaItem: MediaItem?, reason: Int) {
                    super.onMediaItemTransition(mediaItem, reason)
                    when(reason){
                        Player.MEDIA_ITEM_TRANSITION_REASON_AUTO ->{
                            _song.value = _playlist.value!!.get(player!!.currentMediaItemIndex)
                        }
                        Player.MEDIA_ITEM_TRANSITION_REASON_SEEK ->{
                            _song.value = _playlist.value!!.get(player!!.currentMediaItemIndex)
                        }
                    }
                }

                override fun onIsPlayingChanged(isPlaying: Boolean) {
                    super.onIsPlayingChanged(isPlaying)
                    when(isPlaying){
                        true->{
                            _isSongPlaying.value = true
                        }
                        false->{
                            _isSongPlaying.value = false
                        }
                    }
                }

                override fun onPlaybackStateChanged(playbackState: Int) {
                super.onPlaybackStateChanged(playbackState)
                when(playbackState){
                    Player.STATE_BUFFERING -> {
                        _currentSongDurationInText.value = "-:--"
                    }
                    Player.STATE_READY -> {

                        _currentSongDuration.value = player!!.duration

                        _errorViewVisible.value = false

                        formatTotalTime()
                    }
                    Player.STATE_IDLE ->{
                        if(errorViewVisible.value!!)
                            player!!.prepare()
                    }
                }
            }

            override fun onPlayerError(error: PlaybackException) {
                super.onPlayerError(error)
                when(error.errorCode){
                    PlaybackException.ERROR_CODE_IO_NETWORK_CONNECTION_FAILED ->{
                        _errorViewVisible.value = true
                        _errorViewText.value = error.message
                    }
                    else->{
                        _errorViewVisible.value = false
                    }
                }
            }
        })

        updateCurrentPlayerPosition()
    }
    fun getIsQueue(): Boolean{
        player?.let { exoPlayer ->
            return player!!.mediaItemCount > 0
        }
        return false
    }

    fun releasePlayer() {
        player?.let {
            it.release()
        }
        player = null
    }

    private fun updateCurrentPlayerPosition() {
        serviceScope.launch {
            while (true) {
                player?.let{
                    val position = player!!.currentPosition
                    //val position = playbackState.value?.currentPlaybackPosition
                    if (_currentProgress.value!! != position) {
                        _currentProgress.postValue(position)
                        //_curSongDuration.postValue(MusicService.currentSongDuration)
                    }
                    delay(100L)
                }
            }
        }
    }

    //viewmodel
    fun setSnackbar(isVisible: Boolean){
        _snackbarVisible.value = isVisible
    }

    fun formatTotalTime(){
        _currentSongDurationInText.value = String.format(
            "%d:%02d",
            TimeUnit.MILLISECONDS.toMinutes(_currentSongDuration.value!!) % TimeUnit.HOURS.toMinutes(1),
            TimeUnit.MILLISECONDS.toSeconds(_currentSongDuration.value!!) % TimeUnit.MINUTES.toSeconds(1)
        )
    }

    //viewmodel
    fun formatTime(value: Long): String{
        return String.format(
            "%d:%02d",
            TimeUnit.MILLISECONDS.toMinutes(value) % TimeUnit.HOURS.toMinutes(1),
            TimeUnit.MILLISECONDS.toSeconds(value) % TimeUnit.MINUTES.toSeconds(1)
        )
    }
    /*
    val mediaDescriptionAdapter = object : PlayerNotificationManager.MediaDescriptionAdapter{

        override fun getCurrentContentTitle(player: Player): CharSequence = if(_song.value != null){ _song.value!!.songName } else{ "" }

        override fun createCurrentContentIntent(player: Player): PendingIntent? {
            val intent = Intent(this@MusicService, SongFragment::class.java)
            return PendingIntent.getActivity(this@MusicService, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
        }

        override fun getCurrentContentText(player: Player): CharSequence? = if(_song.value != null){ _song.value!!.albumName } else{ "" }

        override fun getCurrentLargeIcon(player: Player, callback: PlayerNotificationManager.BitmapCallback): Bitmap? {
            if(_song.value != null){
                var myBitmap: Bitmap? = null

                Glide.with(this@MusicService)
                    .asBitmap()
                    .load(_song.value!!.songSource)
                    .into(object : CustomTarget<Bitmap>(){
                        override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                            myBitmap = resource
                        }
                        override fun onLoadCleared(placeholder: Drawable?) {
                            // this is called when imageView is cleared on lifecycle call or for
                            // some other reason.
                            // if you are referencing the bitmap somewhere else too other than this imageView
                            // clear it here as you can no longer have the bitmap
                        }
                    })
                return myBitmap
            }
            else{
                return BitmapFactory.decodeResource(resources, R.drawable.queens_of_the_stone_age_lullabies_to_paralyze)
            }
        }
    }

 */
/*
    val notificationListener = object : PlayerNotificationManager.NotificationListener{
        override fun onNotificationPosted(notificationId: Int, notification: Notification, ongoing: Boolean) {
            startForeground(notificationId, notification)
        }

        override fun onNotificationCancelled(notificationId: Int, dismissedByUser: Boolean) {
            stopSelf()
            stopForeground(true)
        }
    }

 */
/*
    private fun initPlayerNotificationManager() {
        playerNotification = PlayerNotificationManager.Builder(
            this, notificationId, channelId)
            .setMediaDescriptionAdapter(mediaDescriptionAdapter)
            .setNotificationListener(notificationListener)
            .setPreviousActionIconResourceId(R.drawable.ic_baseline_skip_previous_24)
            .setNextActionIconResourceId(R.drawable.ic_baseline_skip_next_24)
    }

 */

    /*
    fun createMyNotification(){
        val chan = NotificationChannel(
            channelId,
            "music", NotificationManager.IMPORTANCE_NONE
        )
        chan.lockscreenVisibility = Notification.VISIBILITY_PRIVATE

        val service = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        service.createNotificationChannel(chan)
    }
     */
}