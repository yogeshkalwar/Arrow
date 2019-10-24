package com.yogi.android.arrow.model

import com.google.gson.annotations.SerializedName

/**
 *
 * Created on 2019-10-15.
 */
data class Error(@SerializedName("cod") var code: Int = 200,
                 @SerializedName("message") var message: String = "") {

    override fun toString(): String {
        return "{code=%d, message=%s}".format(code, message)
    }
}