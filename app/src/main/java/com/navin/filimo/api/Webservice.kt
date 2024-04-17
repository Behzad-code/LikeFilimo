package com.navin.filimo.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Webservice {

    var retrofit = Retrofit.Builder().
    baseUrl("http://mobilemasters.ir/apps/filimo-android/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}