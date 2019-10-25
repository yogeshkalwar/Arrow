package com.yogi.android.arrow.di

import com.yogi.android.arrow.BaseTest
import dagger.Component
import javax.inject.Singleton

/**
 * Created on 2019-10-25.
 */
@Singleton
@Component(modules = [
    TestApplicationModule::class,
    RepositoryModule::class,
    TestRxJavaModule::class])
interface TestAppComponent {
    fun inject(baseTest: BaseTest)
}