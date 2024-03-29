package com.yogi.android.arrow.di

import android.app.Application
import android.content.Context
import com.yogi.android.arrow.helper.ContextResource
import com.yogi.android.arrow.helper.Resource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created on 2019-10-23.
 */
@Module(includes = arrayOf(ViewModelModule::class))
internal class ApplicationModule {

    @Singleton
    @Provides
    fun providesContext(app: Application) : Context = app

    @Singleton
    @Provides
    fun providesContextResource(app: Context): Resource = ContextResource(app)
}