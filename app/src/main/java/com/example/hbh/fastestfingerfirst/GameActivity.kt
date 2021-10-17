package com.example.hbh.fastestfingerfirst

import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.ImageView

class GameActivity : AppCompatActivity() {

    private lateinit var aAnswerField: ImageView
    private lateinit var markedAAnswerField: ImageView
    private lateinit var bAnswerField: ImageView
    private lateinit var markedBAnswerField: ImageView
    private lateinit var cAnswerField: ImageView
    private lateinit var markedCAnswerField: ImageView
    private lateinit var dAnswerField: ImageView
    private lateinit var markedDAnswerField: ImageView
    private lateinit var delButton: Button
    private lateinit var confirmButton: Button
    private lateinit var selectedAnswerButton1: Button
    private lateinit var selectedAnswerButton2: Button
    private lateinit var selectedAnswerButton3: Button
    private lateinit var selectedAnswerButton4: Button
    private lateinit var standbyMusic: MediaPlayer
    private lateinit var answeringMusic: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        standbyMusic = MediaPlayer.create(applicationContext, R.raw.standby_for_fastest_finger_first_question)
        answeringMusic = MediaPlayer.create(applicationContext, R.raw.fastest_finger_first_answering)
        standbyMusic.start()
        val standbyHandler = Handler()
        standbyHandler.postDelayed({
            standbyMusic.stop()
            setMarkingAnswerFields()
            showFunctionalButtons()
            answeringMusic.start()
        }, standbyMusic.duration.toLong() - 2000)
    }

    private fun setMarkingAnswerFields() {
        aAnswerField = findViewById(R.id.answer_a_field)
        markedAAnswerField = findViewById(R.id.marked_answer_a_field)
        aAnswerField.setOnClickListener{
            aAnswerField.visibility = View.GONE
            markedAAnswerField.visibility = View.VISIBLE
        }
        bAnswerField = findViewById(R.id.answer_b_field)
        markedBAnswerField = findViewById(R.id.marked_answer_b_field)
        bAnswerField.setOnClickListener{
            bAnswerField.visibility = View.GONE
            markedBAnswerField.visibility = View.VISIBLE
        }
        cAnswerField = findViewById(R.id.answer_c_field)
        markedCAnswerField = findViewById(R.id.marked_answer_c_field)
        cAnswerField.setOnClickListener{
            cAnswerField.visibility = View.GONE
            markedCAnswerField.visibility = View.VISIBLE
        }
        dAnswerField = findViewById(R.id.answer_d_field)
        markedDAnswerField = findViewById(R.id.marked_answer_d_field)
        dAnswerField.setOnClickListener{
            dAnswerField.visibility = View.GONE
            markedDAnswerField.visibility = View.VISIBLE
        }
    }

    private fun showFunctionalButtons() {
        delButton = findViewById(R.id.delButton)
        delButton.visibility = View.VISIBLE

        confirmButton = findViewById(R.id.confirmButton)
        confirmButton.visibility = View.VISIBLE

        selectedAnswerButton1 = findViewById(R.id.selectedAnswerButton1)
        selectedAnswerButton1.visibility = View.VISIBLE

        selectedAnswerButton2 = findViewById(R.id.selectedAnswerButton2)
        selectedAnswerButton2.visibility = View.VISIBLE

        selectedAnswerButton3 = findViewById(R.id.selectedAnswerButton3)
        selectedAnswerButton3.visibility = View.VISIBLE

        selectedAnswerButton4 = findViewById(R.id.selectedAnswerButton4)
        selectedAnswerButton4.visibility = View.VISIBLE
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
