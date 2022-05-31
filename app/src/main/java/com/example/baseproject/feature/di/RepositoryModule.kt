package com.example.baseproject.feature.di

import com.example.baseproject.feature.data.local.CharacterDAO
import com.example.baseproject.feature.data.remote.MainClient
import com.example.baseproject.feature.data.repository.ImplMainRepository
import com.example.baseproject.feature.data.repository.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {
        @Provides
        @ViewModelScoped
        fun provideMainRepository(
            mainClient: MainClient,
            characterDAO: CharacterDAO
        ): MainRepository {
            return ImplMainRepository(mainClient,characterDAO)
        }
}