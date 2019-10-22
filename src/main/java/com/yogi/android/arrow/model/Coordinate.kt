package com.yogi.android.arrow.model

import com.google.gson.annotations.SerializedName

/**
 *
 * Created on 2019-10-14.
 */
data class Coordinate(@SerializedName("lon") var longitude: Float = 0.0f,
                      @SerializedName("lat") var lattitude: Float = 0.0f)