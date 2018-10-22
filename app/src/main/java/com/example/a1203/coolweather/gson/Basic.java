package com.example.a1203.coolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * @author littlecorgi
 * @Date 2018-10-21 15:18
 * @email a1203991686@126.com
 */
public class Basic {

    @SerializedName("city")
    public String cityName;

    @SerializedName("id")
    public String weatherId;

    public Update update;

    public class Update {

        @SerializedName("loc")
        public String updataTime;
    }
}
