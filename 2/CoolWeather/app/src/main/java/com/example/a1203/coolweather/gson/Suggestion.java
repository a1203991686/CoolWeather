package com.example.a1203.coolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * @author littlecorgi
 * @Date 2018-10-21 15:26
 * @email a1203991686@126.com
 */
public class Suggestion {

    @SerializedName("comf")
    public Comfort comfort;

    @SerializedName("cw")
    public CarWash carWash;

    public Sport sport;

    public class Comfort{
        @SerializedName("txt")
        public String info;
    }

    public class CarWash{
        @SerializedName("txt")
        public String info;
    }

    public class Sport{
        @SerializedName("txt")
        public String info;
    }
}
