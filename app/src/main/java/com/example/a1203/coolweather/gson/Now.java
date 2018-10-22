package com.example.a1203.coolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * @author littlecorgi
 * @Date 2018-10-21 15:25
 * @email a1203991686@126.com
 */
public class Now {

    @SerializedName("tmp")
    public String temperature;

    @SerializedName("cond")
    public More more;

    public class More{
        @SerializedName("txt")
        public String info;
    }
}
