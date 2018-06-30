package com.github.crevax.androidbase.di

import android.app.Application
import android.content.Context
import com.github.crevax.androidbase.BaseApplication
import com.github.crevax.androidbase.AppLifecycleCallbacks
import com.github.crevax.androidbase.ReleaseAppLifecycleCallbacks
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun provideAppLifecycleCallbacks(): AppLifecycleCallbacks = ReleaseAppLifecycleCallbacks()

    @Singleton
    @Provides
    fun provideBaseApplication(application: Application): BaseApplication
            = (application as BaseApplication)

    @Singleton
    @Provides
    fun provideContext(application: Application): Context {
        return application.applicationContext
    }
}
