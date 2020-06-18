package com.example.a1203.coolweather.gson;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author littlecorgi
 * @Date 2018-10-21 15:31
 * @email a1203991686@126.com
 */
public class Weather {

    public String status;

    public Basic basic;

    public AQI aqi;

    public Now now;

    public Suggestion suggestion;

    @SerializedName("daily_forecast")
    public List<Forecast> forecastList;
}
