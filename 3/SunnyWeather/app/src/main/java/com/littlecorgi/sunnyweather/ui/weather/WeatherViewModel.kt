package com.littlecorgi.sunnyweather.ui.weather

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.littlecorgi.sunnyweather.logic.Repository
import com.littlecorgi.sunnyweather.logic.model.Event.ClickEvent
import com.littlecorgi.sunnyweather.logic.model.Location

class WeatherViewModel : ViewModel() {

    private val locationLiveData = MutableLiveData<Location>()

    private val _toolbarTextClickEvent = MutableLiveData<ClickEvent>()

    val toolbarTextClickEvent: LiveData<ClickEvent>
        get() = _toolbarTextClickEvent

    var locationLng = ""

    var locationLat = ""

    var placeName = ""

    val weatherLiveData = Transformations.switchMap(locationLiveData) { location ->
        Repository.refreshWeather(location.lng, location.lat)
    }

    fun refreshWeather(lng: String, lat: String) {
        locationLiveData.value = Location(lng, lat)
    }

    fun clickToolbarText() {
        _toolbarTextClickEvent.value = ClickEvent(true)
    }
}