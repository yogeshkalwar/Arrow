package com.yogi.android.arrow.helper

import android.content.Context
import com.yogi.android.arrow.R
import java.io.File
import java.lang.ref.WeakReference

/**
 *
 * Created on 2019-10-15.
 */
class ContextResource: Resource {

    private val resourceIds: Map<String, Int> = hashMapOf(Resource.BASE_URL to R.string.base_url,
                                                        Resource.API_KEY to R.string.api_key)
    private val contextWrapper: WeakReference<Context>

    constructor(context: Context) {
        contextWrapper = WeakReference(context)
    }

    override fun getCacheDir(): File? {
        return getContext()?.cacheDir
    }

    override fun getString(name: String): String? {
        val id = resourceIds.get(name)
        var value: String? = null
        if (id != null) {
            value = getContext()?.getString(id)
        }
        return value
    }

    private fun getContext(): Context? {
        return contextWrapper.get()
    }
}