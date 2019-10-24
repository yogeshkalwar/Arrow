package com.yogi.android.arrow.di

import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Named

/**
 * Created on 2019-10-23.
 */

const val SUBCRIBER_ON = "SubscribeOn"
const val OBSERVER_ON = "ObserverOn"

@Module
class RxJavaModule {

    @Provides
    @Named(SUBCRIBER_ON)
    fun provideSubscribeOn(): Scheduler = Schedulers.io()

    @Provides
    @Named(OBSERVER_ON)
    fun provideObserveOn(): Scheduler = AndroidSchedulers.mainThread()
}