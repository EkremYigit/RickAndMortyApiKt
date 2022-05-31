package com.example.baseproject.feature.di

import android.app.Application
import com.example.baseproject.feature.data.local.CharacterDAO
import com.example.baseproject.feature.data.local.CharacterDatabase
import com.example.baseproject.feature.data.local.CharacterDatabase.Companion.getInstance
import com.example.baseproject.feature.data.remote.MainClient
import com.example.baseproject.feature.data.remote.MainService
import com.example.baseproject.feature.data.remote.NetworkManager
import com.google.gson.Gson
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
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
object ProviderModule {

    @Provides
    @Singleton
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    @Provides
    @Singleton
    fun provideMoshiConverterFactory(moshi: Moshi): MoshiConverterFactory = MoshiConverterFactory.create(moshi)

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().build()
    }

    @Provides
    @Singleton
    fun provideMainService(retrofit: Retrofit): MainService {
        return NetworkManager.createService(MainService::class.java,retrofit)
    }

    @Provides
    @Singleton
    fun provideMainClient(mainService: MainService): MainClient {
        return MainClient(mainService)
    }

    @Provides
    @Singleton
    fun provideGson() = Gson()

    @Singleton
    @Provides
    fun provideDatabase(application: Application) = getInstance(application)

    @Provides
    @Singleton
    fun provideRoomDAO(
        db: CharacterDatabase
    ): CharacterDAO {
        return db.characterDAO()
    }
}