package com.example.revquizsound

import android.content.Intent
import android.media.AudioManager
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_quest.*

class QuestActivity : AppCompatActivity() {
    private lateinit var soundPool: SoundPool
    private var matigai = 0
    private var seikai = 0
    private var syutudai = 0
    private var hakusyu = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quest)

        button3.setOnClickListener{soundPool.play(matigai,1.0f,1.0f,0,0,1.0f)}
        button4.setOnClickListener{soundPool.play(seikai,1.0f,1.0f,0,0,1.0f)}
        button5.setOnClickListener{soundPool.play(syutudai,1.0f,1.0f,0,0,1.0f)}
        button6.setOnClickListener{soundPool.play(hakusyu,1.0f,1.0f,0,0,1.0f)}
        button7.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
    override fun onResume() {
        super.onResume()
        soundPool = SoundPool(1, AudioManager.STREAM_SYSTEM,0)
        matigai = soundPool.load(this,R.raw.quiz2,1)
        seikai = soundPool.load(this,R.raw.quiz1,1)
        syutudai = soundPool.load(this,R.raw.se07,1)
        hakusyu = soundPool.load(this,R.raw.hakusyu,1)
    }

    override fun onPause() {
        super.onPause()
        soundPool.release()
    }

}
