package com.littlecorgi.sunnyweather.logic

import android.util.Log
import androidx.lifecycle.liveData
import com.littlecorgi.sunnyweather.SunnyWeatherApplication
import com.littlecorgi.sunnyweather.logic.dao.PlaceDao
import com.littlecorgi.sunnyweather.logic.model.Place
import com.littlecorgi.sunnyweather.logic.model.Weather
import com.littlecorgi.sunnyweather.logic.network.SunnyWeatherNetwork
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlin.coroutines.CoroutineContext

/**
 * Repository层 用于让ViewModel层和网络请求或本地数据层沟通
 * @author littlecorgi
 */
object Repository {

    // 传入Dispatchers.IO。
    // 先去调用SunnyWeatherNetwork.searchPlaces，返回一个PlaceResponse的对象，
    // 然后根据这个对象的字段去根据情况调用Result的方法返回数据
    fun searchPlaces(query: String) = fire(Dispatchers.IO) {
        val placeResponse = SunnyWeatherNetwork.searchPlaces(query)
        if (placeResponse.status == "ok") {
            val places = placeResponse.places
            Result.success(places)
        } else {
            Result.failure(RuntimeException("response status is ${placeResponse.status}"))
        }
    }


    fun refreshWeather(lng: String, lat: String) = fire(Dispatchers.IO) {
        coroutineScope {
            val deferredRealtime = async {
                SunnyWeatherNetwork.getRealtimeWeather(lng, lat)
            }
            val deferredDaily = async {
                SunnyWeatherNetwork.getDailyWeather(lng, lat)
            }
            Log.d(
                "SunnyWeather",
                "https://api.caiyunapp.com/v2.5/${SunnyWeatherApplication.TOKEN}/${lng},${lat}/realtime.json"
            )
            Log.d(
                "SunnyWeather",
                "https://api.caiyunapp.com/v2.5/${SunnyWeatherApplication.TOKEN}/${lng},${lat}/daily.json"
            )
            // 由于await方法执行时会将当前协程阻塞住，所以此处我们需要先将async函数构建好了之后，再去调用他们的await方法，然后去执行。
            // 这样两个就变成了并行关系。
            val realtimeResponse = deferredRealtime.await()
            val dailyResponse = deferredDaily.await()
            if (realtimeResponse.status == "ok" && dailyResponse.status == "ok") {
                val weather =
                    Weather(realtimeResponse.result.realtime, dailyResponse.result.daily)
                Result.success(weather)
            } else {
                Result.failure(
                    RuntimeException(
                        "realtime response status is ${realtimeResponse.status}" +
                                "daily response status is ${dailyResponse.status}"
                    )
                )
            }
        }
    }

    // liveData函数是一个lifecycle-livedata-ktx提供的一个函数，他可以自动构建并返回一个LiveData对象，
    // 然后在它的代码块中提供一个挂起函数的上下文，这样我们就可以在livaData函数的代码块中调用任意的挂起函数
    // 这个时候我们就用一个Result去承接
    private fun <T> fire(context: CoroutineContext, block: suspend () -> Result<T>) =
        liveData(context) {
            val result = try {
                block()
            } catch (e: Exception) {
                Result.failure<T>(e)
            }
            emit(result)
        }

    fun savePlace(place: Place) = PlaceDao.savePlace(place)

    fun getSavedPlace() = PlaceDao.getSavedPlace()

    fun isSavedPlace() = PlaceDao.isPlaceSaved()
}