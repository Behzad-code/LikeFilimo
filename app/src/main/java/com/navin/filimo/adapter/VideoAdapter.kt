package com.navin.filimo.adapter

import android.app.Activity
import android.content.Intent
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.navin.filimo.R
import com.navin.filimo.activities.VideoPlayerActivity
import com.navin.filimo.models.Video
import com.squareup.picasso.Picasso


class VideoAdapter(myActivity: Activity, list: List<Video>) :
    RecyclerView.Adapter<VideoAdapter.VideoVH>() {
    var activity: Activity = myActivity
    var videoList = list

    class VideoVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgVideo = itemView.findViewById<AppCompatImageView>(R.id.img_video)
        val txtTitle = itemView.findViewById<AppCompatTextView>(R.id.txt_title)
        val constraintVideo = itemView.findViewById<ConstraintLayout>(R.id.constraint_video)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoVH {
        val view = LayoutInflater.from(activity).inflate(R.layout.video_row, null)
        return VideoVH(view)
    }

    override fun getItemCount(): Int {
        return videoList.size
    }

    override fun onBindViewHolder(holder: VideoVH, position: Int) {
        val video = videoList.get(position)
        holder.txtTitle.setText(video.video_title)
        Picasso.get().load(video.video_thumbnail_b).into(holder.imgVideo)


        val typeFace = Typeface.createFromAsset(activity.assets, "fonts/Far_Nazanin.ttf")
        holder.txtTitle.setTypeface(typeFace)

        holder.constraintVideo.setOnClickListener {
            val intent = Intent(activity, VideoPlayerActivity::class.java).apply {
                putExtra("videoObj", video)

            }
            activity.startActivity(intent)
        }
    }
}