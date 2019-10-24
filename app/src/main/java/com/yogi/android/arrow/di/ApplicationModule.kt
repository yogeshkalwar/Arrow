package com.yogi.android.arrow.di

import android.app.Application
import android.content.Context
import com.yogi.android.arrow.helper.ContextResource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created on 2019-10-23.
 */
@Module
internal class ApplicationModule {

    @Singleton
    @Provides
    fun providesContext(app: Application) : Context = app

    @Singleton
    @Provides
    fun providesContextResource(app: Context): ContextResource = ContextResource(app)
}