package com.yogi.android.arrow.di

import com.yogi.android.arrow.di.scope.ActivityScope
import com.yogi.android.arrow.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created on 2019-10-24.
 */
@Module
abstract class ActivityModule {

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity
}