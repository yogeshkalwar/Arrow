package com.yogi.android.arrow.model

import com.google.gson.annotations.SerializedName

/**
 *
 * Created on 2019-10-14.
 */
data class City(@SerializedName("coord") var coordinate: Coordinate?,
                @SerializedName("weather") var weather: List<Weather>?,
                @SerializedName("main") var main: Main?,
                @SerializedName("visibility") var visibility: Int = 0,
                @SerializedName("wind") var wind : Wind?,
                @SerializedName("clouds") var clouds: Clouds?,
                @SerializedName("dt") var date: Int,
                @SerializedName("id") var id: Int,
                @SerializedName("name") var name: String,
                @SerializedName("cod") var code: Int) {

    fun getFirstWeather() : Weather? {
        var firstValue: Weather? = null
        val size = weather?.size ?: 0
        if (size > 0) {
            firstValue = weather?.get(0)
        }
        return firstValue;
    }

    override fun toString(): String {
        val buffer: StringBuffer = StringBuffer()
        buffer.append("Coordinate:" + coordinate.toString())
        buffer.append(",\nweather:" + getFirstWeather().toString())
        buffer.append(",\nmain:" + main.toString())
        buffer.append(",\nvisibility:" + visibility)
        buffer.append(",\nwind:" + wind.toString())
        buffer.append(",\nclouds:" + clouds.toString())
        buffer.append(",\ndt:"+date)
        buffer.append(",\nid:"+id)
        buffer.append(",\nname:"+name)
        buffer.append(",\ncod:"+code)
        return buffer.toString()
    }
}