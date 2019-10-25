package com.yogi.android.arrow.di

import android.app.Application
import android.content.Context
import com.yogi.android.arrow.helper.Resource
import com.yogi.android.arrow.helper.TestResource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created on 2019-10-23.
 */
@Module(includes = arrayOf(ViewModelModule::class))
internal class TestApplicationModule {

    @Singleton
    @Provides
    fun providesContext(app: Application) : Context = app

    @Singleton
    @Provides
    fun providesContextResource(): Resource = TestResource()
}