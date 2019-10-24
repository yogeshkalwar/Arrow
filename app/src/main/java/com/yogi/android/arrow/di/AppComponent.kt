package com.yogi.android.arrow.di

import android.app.Application
import com.yogi.android.arrow.core.ArrowApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

/**
 * Created on 2019-10-24.
 */
@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    ApplicationModule::class,
    RepositoryModule::class,
    RxJavaModule::class,
    ActivityModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: ArrowApplication)
}