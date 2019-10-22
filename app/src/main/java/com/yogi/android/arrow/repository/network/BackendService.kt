package com.yogi.android.arrow.repository.network

import com.yogi.android.arrow.model.City
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created on 2019-10-14.
 */
interface BackendService {

    companion object {
        const val QUERY_PARAM = "q"
        const val API_KEY = "APPID"
        const val VERSION = "/data/2.5"
    }

    @GET("/data/2.5/weather")
    fun getCityWeather(@Query(QUERY_PARAM) query : String, @Query(API_KEY) apiKey: String?): Single<City>
}