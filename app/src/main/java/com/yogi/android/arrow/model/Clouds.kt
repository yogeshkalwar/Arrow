package com.yogi.android.arrow.model

import com.google.gson.annotations.SerializedName

/**
 *
 * Created on 2019-10-14.
 */
data class Clouds(@SerializedName("all") var all: Int = 0) {

    override fun toString(): String {
        return "%d".format(all)
    }
}