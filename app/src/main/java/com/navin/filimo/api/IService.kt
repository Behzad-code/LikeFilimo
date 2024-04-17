package com.navin.filimo.api

import com.navin.filimo.models.BaseModel
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET

interface IService {
    @GET("api.php?home_videos")
    fun getHome() : Call<ResponseBody>

    @GET("api.php?home_videos")
    fun getHomeData() : Call<BaseModel>
}