package com.example.baseproject.feature.data.remote

import com.example.baseproject.feature.data.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkManager {


    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient,
                        moshiConverterFactory: MoshiConverterFactory): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(moshiConverterFactory)
            .build()
    }

    @Singleton
    fun <T> createService(clazz: Class<T>, retrofit: Retrofit): T {
        return retrofit.create(clazz)
    }
}