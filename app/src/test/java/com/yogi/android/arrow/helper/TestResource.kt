package com.yogi.android.arrow.helper

import java.io.File

/**
 * Created on 2019-10-25.
 */
class TestResource: Resource {

    private val resourceIds: Map<String, String> = hashMapOf(Resource.BASE_URL to "/", Resource.API_KEY to "")

    override fun getCacheDir(): File? = null

    override fun getString(name: String): String? = resourceIds.get(name)
}