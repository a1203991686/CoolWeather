package com.littlecorgi.sunnyweather.logic.dao

import android.content.Context
import androidx.core.content.edit
import com.google.gson.Gson
import com.littlecorgi.sunnyweather.SunnyWeatherApplication
import com.littlecorgi.sunnyweather.logic.model.Place

/**
 * Place数据操作的Dao
 * @author littlecorgi
 */
object PlaceDao {

    /**
     * 保存数据
     */
    fun savePlace(place: Place) {
        sharedPreferences().edit {
            putString("place", Gson().toJson(place))
        }
    }

    /**
     * 获取sp保存到本地的数据
     */
    fun getSavedPlace(): Place {
        val placeJson = sharedPreferences().getString("place", "")
        return Gson().fromJson(placeJson, Place::class.java)
    }

    /**
     * 判断是否保存过这个数据
     */
    fun isPlaceSaved() = sharedPreferences().contains("place")

    // 通过全局context去获取SharedPreferences实例
    private fun sharedPreferences() =
        SunnyWeatherApplication.context.getSharedPreferences("sunny_weather", Context.MODE_PRIVATE)
}