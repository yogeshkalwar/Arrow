package com.yogi.android.arrow.model

import com.google.gson.annotations.SerializedName

/**
 *
 * Created on 2019-10-14.
 */
data class Wind(@SerializedName("speed") var speed : Float = 0.0f,
                @SerializedName("deg") var degree : Int = 0) {

    override fun toString(): String {
        return "{speed=%f, deg=%d}".format(speed, degree)
    }
}