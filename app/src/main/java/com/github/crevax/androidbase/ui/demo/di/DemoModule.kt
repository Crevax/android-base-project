package com.github.crevax.androidbase.ui.demo.di

import android.arch.lifecycle.ViewModel
import com.github.crevax.androidbase.di.ViewModelKey
import com.github.crevax.androidbase.ui.demo.DemoViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class DemoModule {

    @Binds
    @IntoMap
    @ViewModelKey(DemoViewModel::class)
    abstract fun bindDemoViewModel(viewModel: DemoViewModel): ViewModel
}
