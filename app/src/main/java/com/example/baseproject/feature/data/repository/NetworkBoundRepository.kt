package com.example.baseproject.feature.data.repository

import androidx.annotation.MainThread
import androidx.annotation.WorkerThread
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import retrofit2.Response

/**
 * A repository which provides resource from local database as well as remote end point.
 *
 * [RESULT] represents the type for database.
 * [REQUEST] represents the type for network.
 */
@ExperimentalCoroutinesApi
abstract class NetworkBoundRepository<RESULT, REQUEST> {

    fun asFlow() = flow {
        emit(Resource.Success(fetchFromLocal().first()))
        val apiResponse = fetchFromRemote()
        val remotePosts = apiResponse.body()
        if (apiResponse.isSuccessful && remotePosts != null) {
            saveRemoteData(remotePosts)
        } else {
            emit(Resource.Failed(apiResponse.message()))
        }
        emitAll(
            fetchFromLocal().map {
                Resource.Success(it)
            }
        )
    }.catch { e ->
        e.printStackTrace()
        emit(Resource.Failed("Network error! Can't get latest posts."))
    }
    @WorkerThread
    protected abstract suspend fun saveRemoteData(response: REQUEST)
    @MainThread
    protected abstract fun fetchFromLocal(): Flow<RESULT>
    @MainThread
    protected abstract suspend fun fetchFromRemote(): Response<REQUEST>
}
