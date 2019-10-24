package com.yogi.android.arrow.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.android.AndroidInjection

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        initDagger()
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
    }

    open fun initDagger() {
        AndroidInjection.inject(this)
    }

    abstract open fun getLayoutId(): Int
}
