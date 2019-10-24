package com.yogi.android.arrow.ui

import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import butterknife.BindView
import butterknife.ButterKnife
import com.yogi.android.arrow.R
import com.yogi.android.arrow.model.City
import com.yogi.android.arrow.viewmodel.ViewModelContract
import com.yogi.android.arrow.viewmodel.ViewModelFactory
import com.yogi.android.arrow.viewmodel.city.CityWeatherViewModel
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @BindView(R.id.activity_main_weather)
    lateinit var weatherText: TextView

    @Inject lateinit var viewModelFactory: ViewModelFactory
    lateinit var viewModelContract: ViewModelContract

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        ButterKnife.bind(this)
        init()
    }

    private fun init() {
        viewModelContract = ViewModelProviders.of(this, viewModelFactory).get(CityWeatherViewModel::class.java)
        (viewModelContract as CityWeatherViewModel).getCity().observe(this, Observer { city -> onDataUpdate(city)})
        viewModelContract.load()
    }

    fun onDataUpdate(city: City) {
        weatherText.setText(city.toString())
    }

    override fun getLayoutId(): Int = R.layout.activity_main
}