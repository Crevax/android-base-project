package com.github.crevax.androidbase.ui.demo

import com.github.crevax.androidbase.services.demo.IDemoService
import com.github.crevax.androidbase.ui.common.base.BaseViewModel
import javax.inject.Inject

class DemoViewModel @Inject constructor(private val demoService: IDemoService) : BaseViewModel() {
    fun submit(text: CharSequence) : String {
        return demoService.reverse(text.toString())
    }
}
