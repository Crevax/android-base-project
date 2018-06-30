package com.github.crevax.androidbase.ui.demo

import android.arch.lifecycle.MutableLiveData
import com.github.crevax.androidbase.services.demo.IDemoService
import com.github.crevax.androidbase.ui.common.base.BaseViewModel
import com.github.crevax.androidbase.util.SingleLiveEvent
import javax.inject.Inject

class DemoViewModel @Inject constructor(private val demoService: IDemoService) : BaseViewModel() {
    private val demoTextMessage = SingleLiveEvent<String>()

    var userInput = MutableLiveData<String>()


    fun submitText() {
        demoTextMessage.value = userInput.value?.let { msg->
            demoService.reverse(msg)
        }
    }

    fun getMessage() : SingleLiveEvent<String> {
        return demoTextMessage
    }
}
