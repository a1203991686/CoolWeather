package com.littlecorgi.sunntweather.logic.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * 构建Retrofit接口实体类的对应工具类
 * @author littlecorgi
 */
object ServiceCreator {

    private const val BASE_URL = "https://api.caiyunapp.com/"

    // 构建Retrofit实例，保证全局只有一个Retrofit实例(因为只要一类网络请求接口，如果还有其他Base_URL就需要再创建对应的Retrofit实例)
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    // 通过传入的泛型去构建对应的接口的实例
    fun <T> create(serviceClass: Class<T>): T = retrofit.create(serviceClass)

    // 简化create方法
    inline fun <reified T> create(): T = create(T::class.java)
}