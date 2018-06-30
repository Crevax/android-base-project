package com.github.crevax.androidbase

interface AppLifecycleCallbacks {
    fun onCreate(app: BaseApplication)
    fun onTerminate(app: BaseApplication)
}
