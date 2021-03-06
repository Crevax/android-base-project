package com.github.crevax.androidbase.ui.common.base

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.View
import javax.inject.Inject
import com.github.crevax.androidbase.di.Injectable
import com.github.crevax.androidbase.ui.common.ViewLifeCycleFragment

abstract class BaseFragment<TViewModel: BaseViewModel>
    : ViewLifeCycleFragment(), Injectable {

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory

    protected abstract val viewModelClassToken: Class<TViewModel>

    protected open lateinit var vm: TViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        vm = provideViewModel()
        vm.start()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        subscribeUI()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (vm as? LifeCycleViewModel)?.startLoading(lifeCycleOwner)
    }

    /**
     * provideViewModel
     * is an optionally override-able method in the event a subclass needs to return a special instance of
     * it's respective view model.
     *
     * The default behavior is to use the lifecycle scope of the fragment, but could be
     * overridden to in the event a fragment needs to use its parent activity scope, etc
     */
    protected open fun provideViewModel(): TViewModel = ViewModelProviders.of(this, viewModelFactory).get(viewModelClassToken)
}
