package com.littlecorgi.sunnyweather.ui.livedata.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LiveDataViewModel : ViewModel() {
    private val _liveDataA = MutableLiveData<String>()

    val liveDataA: LiveData<String>
        get() = _liveDataA

    fun setLiveDataA(s: String) {
        _liveDataA.value = s
    }
}