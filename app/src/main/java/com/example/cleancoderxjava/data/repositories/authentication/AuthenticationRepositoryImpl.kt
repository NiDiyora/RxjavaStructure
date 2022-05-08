package com.example.cleancoderxjava.data.repositories.authentication

import com.example.cleancoderxjava.data.dataSource.remote.AuthenticationRemoteDateSource
import com.example.cleancoderxjava.data.dataSource.remote.IAuthenticationRemoteDataSource
import com.example.cleancoderxjava.data.model.exceptions.HaveNotSetUpLocationWarning
import io.reactivex.rxjava3.core.Completable
import javax.inject.Inject

class AuthenticationRepositoryImpl @Inject constructor(private val authenticationRemoteDateSource: IAuthenticationRemoteDataSource) :
    AuthenticationRepository {
    override fun login(email: String, password: String): Completable {
        return authenticationRemoteDateSource.login(email, password)
            .flatMapCompletable {
                if (it.token?.isBlank() == true)
                    Completable.error(HaveNotSetUpLocationWarning())
                else
                    Completable.complete()
            }
    }
}

