package com.yogi.android.arrow.helper

import java.io.File

/**
 *
 * Created on 2019-10-15.
 */
interface Resource {

    fun getString(id: String): String?
    fun getCacheDir(): File?

    companion object {
        const val BASE_URL = "base_url"
        const val API_KEY = "api_key"
    }
}