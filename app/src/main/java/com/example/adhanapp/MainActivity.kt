package com.example.adhanapp

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun startService(v: View?) {
        val input = "Prayer Time"

        val  sound: MediaPlayer = MediaPlayer.create(this,R.raw.azan)
        val serviceIntent = Intent(this, AdhanService::class.java)
        serviceIntent.putExtra("inputExtra", input)

        ContextCompat.startForegroundService(this, serviceIntent)
        println("hi!")

        sound.start()

    }

    fun stopService(v: View?) {
        val serviceIntent = Intent(this, AdhanService::class.java)
        stopService(serviceIntent)

    }
}