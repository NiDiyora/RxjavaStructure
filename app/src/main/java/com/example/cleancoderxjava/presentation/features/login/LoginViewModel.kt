package com.example.cleancoderxjava.presentation.features.login

import com.example.cleancoderxjava.comman.rxjava.applyIO
import com.example.cleancoderxjava.data.repositories.authentication.AuthenticationRepository
import com.example.cleancoderxjava.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val authenticationRepository: AuthenticationRepository) :
    BaseViewModel<LoginViewState, LoginEvent>() {

    override fun initState(): LoginViewState = LoginViewState(loading = false)

    fun login(email: String, password: String) {
        dispatchState(currentState.copy(loading = true))
        authenticationRepository.login(email, password)
            .applyIO()
            .doFinally { dispatchState(currentState.copy(loading = false)) }
            .subscribe(
                {
                    dispatchEvent(LoginSuccessEvent)
                },
                { error ->
                    dispatchEvent(LoginFailedEvent(error))
                },
            )
    }

}