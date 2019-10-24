package com.yogi.android.arrow.viewmodel.city

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.yogi.android.arrow.model.City
import com.yogi.android.arrow.repository.Repository
import com.yogi.android.arrow.viewmodel.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

/**
 * Created on 2019-10-24.
 */
class CityWeatherViewModel @Inject constructor(private val repository: Repository): BaseViewModel() {

    private val data: MutableLiveData<City> = MutableLiveData()

    override fun load() {
        repository.getCityWeather("London,uk")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSuccess { t: City? -> onSuccess(t) }
            .doOnError { t: Throwable? ->  Timber.d(t)}
            .subscribe()
    }

    private fun onSuccess( city: City?) {
        data.value = city
        if (city != null) {
            Timber.d(city.name)
        }
    }

    fun getCity(): LiveData<City> = data
}