package com.example.baseproject.feature.data.repository

import com.example.baseproject.feature.data.local.CharacterDAO
import com.example.baseproject.feature.data.local.entity.CharacterEntity
import com.example.baseproject.feature.data.model.rickandmorty.Characters
import com.example.baseproject.feature.data.remote.MainClient
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import javax.inject.Inject

interface MainRepository {
    fun getAllCharacters(): Flow<Resource<List<CharacterEntity>>>
}

class ImplMainRepository @Inject constructor(
    private val mainClient: MainClient,
    private val characterDAO: CharacterDAO
    ): MainRepository {

    @OptIn(ExperimentalCoroutinesApi::class)
    override fun getAllCharacters(): Flow<Resource<List<CharacterEntity>>> {
        return object : NetworkBoundRepository<List<CharacterEntity>,Characters>() {

            override fun fetchFromLocal(): Flow<List<CharacterEntity>> = characterDAO.getAllCharacterDetails()

            override suspend fun fetchFromRemote(): Response<Characters> {
                return mainClient.getApiData()
            }
            override suspend fun saveRemoteData(response: Characters) {
                characterDAO.insertCharacters(response.results)
            }

        }.asFlow()
    }
}