package com.yogi.android.arrow.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yogi.android.arrow.R
import com.yogi.android.arrow.helper.ContextResource
import com.yogi.android.arrow.helper.Resource
import com.yogi.android.arrow.model.City
import com.yogi.android.arrow.repository.NetworkOnlyRepository
import com.yogi.android.arrow.repository.network.LiveApiService
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        test()
    }

    private fun test() {
        var resource = ContextResource(this)
        var apiService = LiveApiService(resource, false)
        var repository = NetworkOnlyRepository(apiService);
        repository.getCityWeather("London,uk")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSuccess { t: City? -> printCity(t) }
            .doOnError { t: Throwable? ->  Timber.d(t)}
            .subscribe()
    }

    private fun printCity( city: City?) {
        if (city != null) {
            Timber.d(city.name)
        }
    }
}
