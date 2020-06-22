package com.littlecorgi.sunntweather.logic.model

import com.google.gson.annotations.SerializedName

/**
 * 实况天气接口实体类
 * https://open.caiyunapp.com/%E5%AE%9E%E5%86%B5%E5%A4%A9%E6%B0%94%E6%8E%A5%E5%8F%A3/v2.5
 * @author littlecorgi
 */
data class RealtimeResponse(val status: String, val result: Result) {

    data class Result(val realtime: Realtime)

    data class Realtime(
        val skycon: String,
        val temperature: Float,
        @SerializedName("air_quality") val airQuality: AirQuality
    )

    data class AirQuality(val aqi: AQI)

    data class AQI(val chn: Float)

}