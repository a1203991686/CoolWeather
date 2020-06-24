package com.littlecorgi.sunnyweather.logic.model

sealed class Event {
    data class ClickEvent(var isClick: Boolean)
}