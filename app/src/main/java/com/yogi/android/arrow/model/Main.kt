package com.yogi.android.arrow.model

import com.google.gson.annotations.SerializedName

/**
 *
 * Created on 2019-10-14.
 */
data class Main(@SerializedName("temp") var temperature : Float = 0.0f,
                @SerializedName("pressure") var pressure: Int = 0,
                @SerializedName("humidity") var humidity: Int = 0,
                @SerializedName("temp_min") var minTemperature: Float = 0.0f,
                @SerializedName("temp_max") var maxTemperature: Float = 0.0f) {

    override fun toString(): String {
        return "{temp=%f, pressure=%d, humidity=%d, minTemp=%f, maxTemp=%f}".format(temperature, pressure, humidity, minTemperature, maxTemperature)
    }
}