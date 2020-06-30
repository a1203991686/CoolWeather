package com.littlecorgi.sunnyweather.ui.livedata.switchmap

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LiveDataSwitchMapViewModel : ViewModel() {

    private val _liveDataA = MutableLiveData<String>()
    val liveDataA: LiveData<String>
        get() = _liveDataA

    private val _liveDataB = MutableLiveData<String>()
    val liveDataB: LiveData<String>
        get() = _liveDataB

    private val _switchLiveData = MutableLiveData<Boolean>()
    val switchLiveData: LiveData<Boolean>
        get() = _switchLiveData

    fun setLiveDataA(str: String) {
        _liveDataA.value = str
    }

    fun setLiveDataB(str: String) {
        _liveDataB.value = str
    }

    fun setSwitchLiveData(b: Boolean) {
        _switchLiveData.value = b
    }
}