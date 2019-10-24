package com.yogi.android.arrow.ui

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.yogi.android.arrow.R
import com.yogi.android.arrow.viewmodel.ViewModelContract
import com.yogi.android.arrow.viewmodel.ViewModelFactory
import com.yogi.android.arrow.viewmodel.city.CityWeatherViewModel
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject lateinit var viewModelFactory: ViewModelFactory
    lateinit var viewModelContract: ViewModelContract

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        viewModelContract = ViewModelProviders.of(this, viewModelFactory).get(CityWeatherViewModel::class.java)
        viewModelContract.load()
    }

    override fun getLayoutId(): Int = R.layout.activity_main
}