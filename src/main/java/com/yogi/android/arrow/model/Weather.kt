package com.yogi.android.arrow.model

import com.google.gson.annotations.SerializedName

/**
 *
 * Created on 2019-10-14.
 */
data class Weather(@SerializedName("id") var id: Int = 0,
                   @SerializedName("main") var main: String?,
                   @SerializedName("description") var description: String?,
                   @SerializedName("icon") var icon: String?)