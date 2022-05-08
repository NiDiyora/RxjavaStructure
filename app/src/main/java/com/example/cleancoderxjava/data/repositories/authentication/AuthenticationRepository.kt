package com.example.cleancoderxjava.data.repositories.authentication

import io.reactivex.rxjava3.core.Completable

interface AuthenticationRepository {

    fun login(email: String, password: String): Completable
}