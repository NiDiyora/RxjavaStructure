package com.example.cleancoderxjava.di

import com.example.cleancoderxjava.BuildConfig
import com.example.cleancoderxjava.data.dataSource.remote.api.ApiConstant
import com.example.cleancoderxjava.data.dataSource.remote.api.ApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    private val jsonConfig = Json {
        encodeDefaults = true
        ignoreUnknownKeys = true
    }
    @Provides
    @Singleton
    fun getRerofitServiceInstance(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun getRetrofitInstance(): Retrofit {
        val interceptor = HttpLoggingInterceptor()
        if (BuildConfig.DEBUG) {
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        }
        val responseContentType = "application/json".toMediaType()
        val converterFactory = jsonConfig.asConverterFactory(responseContentType)
        val client: OkHttpClient = OkHttpClient.Builder().addInterceptor(interceptor).build()
        return Retrofit.Builder()
            .addConverterFactory(converterFactory)
            .baseUrl(ApiConstant.BASE_URL)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .client(client)
            .build()
    }
}