package com.example.cleancoderxjava.di

import com.example.cleancoderxjava.data.repositories.authentication.AuthenticationRepository
import com.example.cleancoderxjava.data.repositories.authentication.AuthenticationRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoriesModule {

    @Binds
    abstract fun provideAuthenticationRepository(
        repository: AuthenticationRepositoryImpl
    ): AuthenticationRepository


}