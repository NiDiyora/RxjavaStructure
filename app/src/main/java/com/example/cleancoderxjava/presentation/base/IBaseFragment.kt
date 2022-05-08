package com.example.cleancoderxjava.presentation.base

import android.os.Bundle
import com.example.cleancoderxjava.comman.views.SafetyClickListener

interface IBaseFragment {

    val baseActivity: BaseActivity?

    val safetyClickListener: SafetyClickListener

    fun getLayoutId(): Int

    fun initData(data: Bundle?)

    fun initViews()

    fun initActions()

    fun initObservers()

    fun onBackPressed()

    fun showLoading()

    fun hideLoading()



}