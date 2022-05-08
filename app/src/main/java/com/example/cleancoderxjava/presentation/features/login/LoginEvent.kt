package com.example.cleancoderxjava.presentation.features.login

sealed class LoginEvent

object LoginSuccessEvent : LoginEvent()

data class LoginFailedEvent(val error: Throwable) : LoginEvent()
