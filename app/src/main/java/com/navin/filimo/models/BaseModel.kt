package com.navin.filimo.models

import com.google.gson.annotations.SerializedName

data class BaseModel(
    @SerializedName("ALL_IN_ONE_VIDEO")
    val baseVideoModel: BaseVideoModel
)