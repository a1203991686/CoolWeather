package com.littlecorgi.sunntweather.logic.model

/**
 * 为了方便，将实时天气和天级预报聚合成一个类
 */
data class Weather(val realtime: RealtimeResponse.Realtime, val daily: DailyResponse.Daily)