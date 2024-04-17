package com.navin.filimo.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Video(
    val cat_id: String,
    val category_image: String,
    val category_image_thumb: String,
    val category_name: String,
    val cid: String,
    val id: String,
    val rate_avg: String,
    val totel_viewer: String,
    val video_description: String,
    val video_duration: String,
    val video_id: String,
    val video_thumbnail_b: String,
    val video_thumbnail_s: String,
    val video_title: String,
    val video_type: String,
    val video_url: String
) : Parcelable