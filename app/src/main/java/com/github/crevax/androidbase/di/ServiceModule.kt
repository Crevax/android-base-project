package com.github.crevax.androidbase.di

import com.github.crevax.androidbase.services.demo.DemoService
import com.github.crevax.androidbase.services.demo.IDemoService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ServiceModule {

    @Singleton
    @Provides
    fun provideDemoService() : IDemoService = DemoService()
}
