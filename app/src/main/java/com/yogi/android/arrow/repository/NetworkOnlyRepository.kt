package com.yogi.android.arrow.repository

import com.yogi.android.arrow.model.City
import io.reactivex.Single

/**
 * Created on 2019-10-14.
 */
open class NetworkOnlyRepository: Repository {

    val apiService: Repository

    constructor(apiService: Repository) {
        this.apiService = apiService
    }

    override fun getCityWeather(city: String): Single<City> {
        return apiService.getCityWeather(city)
    }
}