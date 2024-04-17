package com.navin.filimo.models

import com.google.gson.annotations.SerializedName

data class BaseVideoModel(
    @SerializedName("all_video")
    val allVideo: List<Video>,

    @SerializedName("category")
    val category: List<Category>,

    @SerializedName("featured_video")
    val featuredVideo: List<Video>,

    @SerializedName("latest_video")
    val latestVideo: List<Video>
)