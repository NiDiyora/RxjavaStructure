package com.example.cleancoderxjava.data.dataSource.remote

import com.example.cleancoderxjava.data.dataSource.remote.api.ApiService
import com.example.cleancoderxjava.data.model.User
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class AuthenticationRemoteDateSource @Inject constructor(private val apiService: ApiService) :
    IAuthenticationRemoteDataSource {
    override fun login(email: String, password: String): Single<User> {
        return apiService.login(email,password)
    }
}