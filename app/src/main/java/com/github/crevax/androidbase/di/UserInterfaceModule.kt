package com.github.crevax.androidbase.di

import android.arch.lifecycle.ViewModelProvider
import com.github.crevax.androidbase.ui.demo.DemoActivity
import com.github.crevax.androidbase.ui.demo.di.DemoModule
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class UserInterfaceModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @ContributesAndroidInjector(modules = [(DemoModule::class)])
    abstract fun contributeDemoActivity(): DemoActivity
}
