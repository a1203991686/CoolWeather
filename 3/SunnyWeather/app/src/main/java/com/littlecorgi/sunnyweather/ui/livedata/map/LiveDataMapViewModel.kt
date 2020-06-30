package com.littlecorgi.sunnyweather.ui.livedata.map

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LiveDataMapViewModel : ViewModel() {

    private val _liveDataA = MutableLiveData<String>()
    val liveDataA: LiveData<String>
        get() = _liveDataA

    fun setLiveDataA(str: String) {
        _liveDataA.value = str
    }
}