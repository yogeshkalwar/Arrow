package com.yogi.android.arrow.repository

import com.yogi.android.arrow.model.City
import io.reactivex.Single

/**
 * Created on 2019-10-14.
 */
interface Repository {

    fun getCityWeather(city: String): Single<City>
}