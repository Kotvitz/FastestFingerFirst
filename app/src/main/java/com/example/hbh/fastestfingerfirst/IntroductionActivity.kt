package com.example.hbh.fastestfingerfirst

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlin.system.exitProcess

class IntroductionActivity : AppCompatActivity() {

    private lateinit var backgroundMusic: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_introduction)
        backgroundMusic = MediaPlayer.create(applicationContext, R.raw.explain_fastest_finger)
        backgroundMusic.start()
        val startGameButton = findViewById<Button>(R.id.startGameButton)
        startGameButton.setOnClickListener {
            MediaPlayer.create(applicationContext, R.raw.click).start()
            backgroundMusic.stop()
            startActivity(Intent(this, GameActivity::class.java))
        }
        val quitButton = findViewById<Button>(R.id.exitButton)
        quitButton.setOnClickListener {
            MediaPlayer.create(applicationContext, R.raw.click).start()
            backgroundMusic.stop()
            exitProcess(0)
        }
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
        }
    }
}