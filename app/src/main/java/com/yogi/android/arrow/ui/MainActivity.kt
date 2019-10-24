package com.yogi.android.arrow.ui

import android.os.Bundle
import com.yogi.android.arrow.R
import com.yogi.android.arrow.model.City
import com.yogi.android.arrow.repository.Repository
import dagger.android.AndroidInjection
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject lateinit var repository: Repository

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        test()
    }

    override fun getLayoutId(): Int = R.layout.activity_main

    private fun test() {
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