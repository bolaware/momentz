package com.bolaware.viewsslidetimer

import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.VideoView
import kotlinx.android.synthetic.main.activity_video.*

class VideoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)
        playVideo()
    }

    fun playVideo(){
        val str = "https://abhiandroid.com/ui/wp-content/uploads/2016/04/videoviewtestingvideo.mp4"
        val uri = Uri.parse(str)

        videoView.setVideoURI(uri)

        videoView.requestFocus()
        videoView.start()

        videoView.setOnPreparedListener {
            Toast.makeText(this, "About to be played", Toast.LENGTH_LONG).show()
        }
    }
}
