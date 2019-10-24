package com.yogi.android.arrow.di

import androidx.lifecycle.ViewModel
import com.yogi.android.arrow.di.annotation.ViewModelKey
import com.yogi.android.arrow.viewmodel.city.CityWeatherViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created on 2019-10-24.
 */
@Module
internal abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(CityWeatherViewModel::class)
    abstract fun bindCityWeatherViewModel(viewModel: CityWeatherViewModel): ViewModel
}