package com.example.cleancoderxjava.presentation.features.login

import android.os.Bundle
import android.widget.Toast

import androidx.fragment.app.viewModels
import com.example.cleancoderxjava.R
import com.example.cleancoderxjava.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_login_screen.*

@AndroidEntryPoint
class LoginScreen : BaseFragment() {

    private val viewModel: LoginViewModel by viewModels()

    override fun getLayoutId(): Int = R.layout.fragment_login_screen


    override fun initData(data: Bundle?) {

    }

    override fun initViews() {


    }

    override fun initActions() {
        safetyClickListener.setViewClickSafetyListener(buttonLogin) {
            viewModel.login(ed_email.text.toString(), ed_passwprd.text.toString())
        }
    }

    override fun initObservers() {
        viewModel.liveEvent.observe(viewLifecycleOwner) { event ->
            when (event) {
                LoginSuccessEvent -> {
                    Toast.makeText(activity, "Login SuccessFully", Toast.LENGTH_SHORT).show()
                }
                is LoginFailedEvent -> {}
                else -> {}
            }
        }
        viewModel.store.observe(
            owner = viewLifecycleOwner,
            selector = { state -> state.loading }) { loading ->
            if (loading) showLoading() else hideLoading()
        }
    }
}