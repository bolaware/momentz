package com.bolaware.viewsslidetimer

import android.graphics.Color
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import android.net.Uri
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.VideoView
import com.bolaware.viewstimerstory.Momentz
import com.bolaware.viewstimerstory.MomentzCallback
import com.bolaware.viewstimerstory.MomentzView
import com.squareup.picasso.Callback
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.Picasso
import toPixel
import java.lang.Exception


class MainActivity : AppCompatActivity(), MomentzCallback {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        // show a textview
        val textView = TextView(this)
        textView.text = "Hello, You can display TextViews"
        textView.textSize = 20f.toPixel(this).toFloat()
        textView.gravity = Gravity.CENTER
        textView.setTextColor(Color.parseColor("#ffffff"))

        //show a customView
        val customView = LayoutInflater.from(this).inflate(R.layout.custom_view, null)



        // show an imageview be loaded from file
        val locallyLoadedImageView = ImageView(this)
        locallyLoadedImageView.setImageDrawable(
            ContextCompat.getDrawable(
                this,
                R.drawable.bieber
            )
        )

        //image to be loaded from the internet
        val internetLoadedImageView = ImageView(this)

        //video to be loaded from the internet
        val internetLoadedVideo = VideoView(this)

        val listOfViews = listOf(
            MomentzView(textView, 5),
            MomentzView(customView, 5),
            MomentzView(locallyLoadedImageView, 6),
            MomentzView(internetLoadedImageView, 10),
            MomentzView(internetLoadedVideo, 60)
        )

        Momentz(this, listOfViews, container, this).start()
    }


    override fun onNextCalled(view: View, momentz: Momentz, index: Int) {
        if (view is VideoView) {
            momentz.pause(true)
            playVideo(view, index, momentz)
        } else if ((view is ImageView) && (view.drawable == null)) {
            momentz.pause(true)
            Picasso.get()
                .load("https://i.pinimg.com/564x/14/90/af/1490afa115fe062b12925c594d93a96c.jpg")
                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                .into(view, object : Callback {
                    override fun onSuccess() {
                        momentz.resume()
                        Toast.makeText(this@MainActivity, "Image loaded from the internet", Toast.LENGTH_LONG).show()
                    }

                    override fun onError(e: Exception?) {
                        Toast.makeText(this@MainActivity,e?.localizedMessage,Toast.LENGTH_LONG).show()
                        e?.printStackTrace()
                    }
                })
        }
    }

    override fun done() {
        Toast.makeText(this@MainActivity, "Finished!", Toast.LENGTH_LONG).show()
    }

    fun playVideo(videoView: VideoView, index: Int, momentz: Momentz) {
        val str = "https://images.all-free-download.com/footage_preview/mp4/triumphal_arch_paris_traffic_cars_326.mp4"
        val uri = Uri.parse(str)

        videoView.setVideoURI(uri)

        videoView.requestFocus()
        videoView.start()

        videoView.setOnInfoListener(object : MediaPlayer.OnInfoListener {
            override fun onInfo(mp: MediaPlayer?, what: Int, extra: Int): Boolean {
                if (what == MediaPlayer.MEDIA_INFO_VIDEO_RENDERING_START) {
                    // Here the video starts
                    momentz.editDurationAndResume(index, (videoView.duration) / 1000)
                    Toast.makeText(this@MainActivity, "Video loaded from the internet", Toast.LENGTH_LONG).show()
                    return true
                }
                return false
            }
        })
    }
}

