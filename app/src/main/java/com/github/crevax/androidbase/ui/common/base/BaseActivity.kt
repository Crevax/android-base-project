package com.github.crevax.androidbase.ui.common.base

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector

abstract class BaseActivity<TViewModel: BaseViewModel> :
        AppCompatActivity(), HasSupportFragmentInjector {

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory
    @Inject lateinit var androidInjector: DispatchingAndroidInjector<Fragment>

    protected abstract val viewModelClassToken: Class<TViewModel>

    protected val vm by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(viewModelClassToken)
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = androidInjector

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        subscribeUI()
        vm.start()
    }

    // Keeps implementation's onCreate cleaner, while ensuring LiveData subscriptions happen there
    protected open fun subscribeUI() {}
}
