package com.littlecorgi.sunntweather.logic.network

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

object SunnyWeatherNetwork {

    // 构建Retrofit对应的接口的实例
    private val placeService = ServiceCreator.create<PlaceService>()

    // 首先通过placeService的searchPlaces方法去获取到 Call 的实例
    // 然后拿着这个 Call 的实例去调用拓展方法await()
    suspend fun searchPlaces(query: String) = placeService.searchPlaces(query).await()

    // 和上面一样
    private val weatherService = ServiceCreator.create<WeatherService>()

    suspend fun getDailyWeather(lng: String, lat: String) =
        weatherService.getDailyWeather(lng, lat).await()

    suspend fun getRealtimeWeather(lng: String, lat: String) =
        weatherService.getRealtimeWeather(lng, lat).await()

    // Call的扩展方法await()
    // 在这个方法中，首先去构建了一个suspendCoroutine定义的协程。
    // suspendCoroutine函数会让当前协程立即挂起，然后在一个普通线程中去执行Lambda表达式中的代码。
    // suspendCoroutine只会阻塞当前协程，既不影响其它协程，也不影响任何线程
    // 在这个方法中，就去调用Call的enqueue方法，传入一个我们继承Callback的匿名内部类，在这个匿名内部类中去重写他的一些onResponse和onFailure方法
    // 如果网络请求成功，Retrofit就会回调onResponse方法，
    // 在这个方法中我们就能通过continuation的resume方法恢复被挂起的协程，并传入服务器的相应数据，这个数据就会作为suspendCoroutine的返回值被return出去
    // 如果网络请求失败，Retrofit就会回调onFailure方法，
    // 在这个方法中，我们就会调用continuation的resumeWithException方法恢复被挂起的协程，并传入具体的异常原因。
    private suspend fun <T> Call<T>.await(): T {
        return suspendCoroutine { continuation ->
            enqueue(object : Callback<T> {
                override fun onFailure(call: Call<T>, t: Throwable) {
                    continuation.resumeWithException(t)
                }

                override fun onResponse(call: Call<T>, response: Response<T>) {
                    val body = response.body()
                    if (body != null) {
                        continuation.resume(body)
                    } else {
                        continuation.resumeWithException(RuntimeException("response body is null"))
                    }
                }
            })
        }
    }
}