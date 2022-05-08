package com.example.cleancoderxjava.data.dataSource.remote.api

import com.example.cleancoderxjava.data.model.User
import io.reactivex.rxjava3.core.Single
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {

    @FormUrlEncoded
    @POST(ApiConstant.login_api)
    fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): Single<User>


}