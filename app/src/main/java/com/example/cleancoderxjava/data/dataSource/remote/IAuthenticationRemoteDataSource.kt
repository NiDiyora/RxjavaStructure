package com.example.cleancoderxjava.data.dataSource.remote

import com.example.cleancoderxjava.data.model.User
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

interface IAuthenticationRemoteDataSource {

    fun login(email: String, password: String): Single<User>
}