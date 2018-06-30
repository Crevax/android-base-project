package com.github.crevax.androidbase

import com.github.crevax.androidbase.di.DaggerAppComponent
import com.github.crevax.androidbase.di.applyAutoInjector
import dagger.android.DaggerApplication
import javax.inject.Inject

class BaseApplication : DaggerApplication() {

    @Inject lateinit var appLifecycleCallbacks: AppLifecycleCallbacks

    override fun applicationInjector() = DaggerAppComponent
            .builder()
            .application(this)
            .build()

    override fun onCreate() {
        super.onCreate()

        applyAutoInjector()
        appLifecycleCallbacks.onCreate(this)
    }

    override fun onTerminate() {
        appLifecycleCallbacks.onTerminate(this)

        super.onTerminate()
    }
}
