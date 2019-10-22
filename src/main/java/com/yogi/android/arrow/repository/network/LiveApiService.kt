package com.yogi.android.arrow.repository.network

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.yogi.android.arrow.BuildConfig
import com.yogi.android.arrow.helper.Resource
import com.yogi.android.arrow.model.City
import com.yogi.android.arrow.repository.Repository
import io.reactivex.Single
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created on 2019-10-14.
 */
class LiveApiService: Repository {

    companion object {
        const val CACHE_50MB: Long = 50 * 1024 * 1024
        const val TIMEOUT: Long = 60
    }
    val resource: Resource
    var apiService: BackendService
    var apiKey: String?

    constructor(resource: Resource, allowRetry: Boolean) {
        this.resource = resource
        apiService = init(allowRetry)
        apiKey = resource.getString(Resource.API_KEY)
    }

    private fun init(allowRetry: Boolean): BackendService {
        val cache = Cache(resource.getCacheDir(), CACHE_50MB)
        val client = OkHttpClient.Builder()
            .cache(cache)
            .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
            .retryOnConnectionFailure(allowRetry)
        if (BuildConfig.DEBUG) {
            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
            client.addInterceptor(logging)
        }
        //TODO: add interceptors here
        val builder = Retrofit.Builder()
            .baseUrl(getBaseUrl())
            .addConverterFactory(GsonConverterFactory.create(getGson()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(client.build())
        return builder.build().create(BackendService::class.java)
    }

    fun getGson(): Gson {
        val gsonBuilder = GsonBuilder()
        return gsonBuilder.create()
    }

    fun getBaseUrl(): String? {
        return resource.getString(Resource.BASE_URL)
    }

    override fun getCityWeather(city: String): Single<City> {
        return apiService.getCityWeather(city, apiKey)
    }
}