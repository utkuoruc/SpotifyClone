package com.example.spotifyclone555.service

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class Broadcast : BroadcastReceiver() {
    override fun onReceive(p0: Context?, p1: Intent?) {
        val action = p1?.action
        p0?.sendBroadcast(Intent("ACTION").putExtra("action", action))
    }
}