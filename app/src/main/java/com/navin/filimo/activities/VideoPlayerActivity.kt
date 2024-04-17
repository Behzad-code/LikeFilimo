package com.navin.filimo.activities

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import com.navin.filimo.databinding.ActivityVideoPlayerBinding
import com.navin.filimo.models.Video


class VideoPlayerActivity : AppCompatActivity() {

    lateinit var binding : ActivityVideoPlayerBinding
    lateinit var bundle: Bundle
    var video : Video? = null
    lateinit var player : ExoPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVideoPlayerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bundle = intent.extras!!

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
            video = bundle.getParcelable("videoObj",Video::class.java)
        }else{
            video = intent?.getParcelableExtra<Video>("videoObj")

        }
        //binding.txtDescription.setText(video?.video_description)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            binding.txtDescription.setText(Html.fromHtml(video?.video_description, Html.FROM_HTML_MODE_COMPACT))
        } else {
            binding.txtDescription.setText(Html.fromHtml(video?.video_description))
        }

        player = ExoPlayer.Builder(applicationContext).build()
        binding.playerView.player = player
        val item = MediaItem.fromUri(video!!.video_url)
        player.addMediaItem(item)
        player.prepare()
        player.play()

    }

    override fun onStop() {
        super.onStop()
        if (player.isPlaying){
            player.stop()
        }
    }
}