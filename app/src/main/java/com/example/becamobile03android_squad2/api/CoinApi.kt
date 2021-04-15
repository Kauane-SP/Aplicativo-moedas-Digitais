package com.example.becamobile03android_squad2.api

import com.example.becamobile03android_squad2.model.Coin
import retrofit2.http.GET
import retrofit2.http.Query

interface CoinApi {

    @GET("v1/assets?")
    fun getAllList(@Query("apiKey") api:String): retrofit2.Call<List<Coin>>
}