package com.littlecorgi.sunnyweather

import android.app.Application
import android.content.Context

class SunnyWeatherApplication : Application() {

    companion object {

        // 请换成你申请的彩云天气的Token
        const val TOKEN = "TbStBMEC2EHzbntf"

        // 全局获取的Context
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}