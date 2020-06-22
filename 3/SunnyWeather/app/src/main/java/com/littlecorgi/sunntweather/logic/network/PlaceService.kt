package com.littlecorgi.sunntweather.logic.network

import com.littlecorgi.sunntweather.SunnyWeatherApplication
import com.littlecorgi.sunntweather.logic.model.PlaceResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * 地址接口的Retrofit网络请求接口
 * @author littlecorgi
 */
interface PlaceService {

    @GET("v2/place?token=${SunnyWeatherApplication.TOKEN}")
    fun searchPlaces(@Query("query") query: String): Call<PlaceResponse>
}