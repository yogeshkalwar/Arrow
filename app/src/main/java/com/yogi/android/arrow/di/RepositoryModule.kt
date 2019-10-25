package com.yogi.android.arrow.di

import com.yogi.android.arrow.helper.Resource
import com.yogi.android.arrow.repository.NetworkOnlyRepository
import com.yogi.android.arrow.repository.Repository
import com.yogi.android.arrow.repository.network.LiveApiService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created on 2019-10-23.
 */
@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideRepository(resource: Resource): Repository = NetworkOnlyRepository(LiveApiService(resource, true))
}