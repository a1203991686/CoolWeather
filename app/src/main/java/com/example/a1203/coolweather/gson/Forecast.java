package com.example.a1203.coolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * @author littlecorgi
 * @Date 2018-10-21 15:29
 * @email a1203991686@126.com
 */
public class Forecast {

    public String date;

    @SerializedName("tmp")
    public Temperature temperature;

    @SerializedName("cond")
    public More more;

    public class Temperature{

        public String max;

        public String min;
    }

    public class More{

        @SerializedName("txt_d")
        public String info;
    }
}
