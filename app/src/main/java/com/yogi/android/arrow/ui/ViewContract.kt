package com.yogi.android.arrow.ui

/**
 * Created on 2019-10-24.
 */
interface ViewContract<T> {

    fun onDataUpdate(data: T)
}