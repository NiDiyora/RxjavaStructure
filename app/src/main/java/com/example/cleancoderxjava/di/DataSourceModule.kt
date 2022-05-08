package com.example.cleancoderxjava.di

import com.example.cleancoderxjava.data.dataSource.remote.AuthenticationRemoteDateSource
import com.example.cleancoderxjava.data.dataSource.remote.IAuthenticationRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class DataSourceModule {

    @Binds
    abstract fun providerAuthenticationRemoteDataSource(
        authenticationRemoteDateSource: AuthenticationRemoteDateSource
    ): IAuthenticationRemoteDataSource


}