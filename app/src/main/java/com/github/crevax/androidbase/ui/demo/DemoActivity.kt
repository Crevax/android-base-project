package com.github.crevax.androidbase.ui.demo

import android.arch.lifecycle.Observer
import android.util.Log
import android.widget.Toast
import com.github.crevax.androidbase.R
import com.github.crevax.androidbase.databinding.ActivityDemoBinding
import com.github.crevax.androidbase.ui.common.base.BaseActivity

class DemoActivity : BaseActivity<DemoViewModel, ActivityDemoBinding>() {

    override val viewModelClassToken = DemoViewModel::class.java
    override val layoutId = R.layout.activity_demo

    override fun subscribeUI() {
        vm.getMessage().observe(this, Observer {
            it.let { msg ->
                Toast.makeText(applicationContext, msg, Toast.LENGTH_LONG).show()
            }
        })
    }
}
