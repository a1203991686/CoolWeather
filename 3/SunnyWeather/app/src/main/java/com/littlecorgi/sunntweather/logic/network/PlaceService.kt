package com.littlecorgi.sunntweather.logic.network

import com.littlecorgi.sunntweather.SunnyWeatherApplication
import com.littlecorgi.sunntweather.logic.model.PlaceResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PlaceService {

    @GET("v2/place?token=${SunnyWeatherApplication.TOKEN}")
    fun searchPlaces(@Query("query") query: String): Call<PlaceResponse>
}