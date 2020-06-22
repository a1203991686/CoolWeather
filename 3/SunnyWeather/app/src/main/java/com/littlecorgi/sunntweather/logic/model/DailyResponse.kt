package com.littlecorgi.sunntweather.logic.model

import com.google.gson.annotations.SerializedName
import java.util.*

/**
 * 天级预报接口实体类
 * https://open.caiyunapp.com/%E5%A4%A9%E7%BA%A7%E9%A2%84%E6%8A%A5%E6%8E%A5%E5%8F%A3/v2.5
 * @author littlecorgi
 */
data class DailyResponse(val status: String, val result: Result) {

    data class Result(val daily: Daily)

    data class Daily(
        val temperature: List<Temperature>,
        val skycon: List<Skycon>,
        @SerializedName("life_index") val lifeIndex: LifeIndex
    )

    data class Temperature(val max: Float, val min: Float)

    data class Skycon(val value: String, val date: Date)

    data class LifeIndex(
        val coldRisk: List<LifeDescription>,
        val carWashing: List<LifeDescription>,
        val ultraviolet: List<LifeDescription>,
        val dressing: List<LifeDescription>
    )

    data class LifeDescription(val desc: String)

}