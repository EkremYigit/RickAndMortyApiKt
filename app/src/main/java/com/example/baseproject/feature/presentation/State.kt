package com.example.baseproject.feature.presentation

import com.example.baseproject.feature.data.repository.Resource

sealed class State<out T> {
    object Empty : State<Nothing>()
    class Loading<T> : State<T>()
    data class Loaded<T>(val data: T) : State<T>()
    data class Error<T>(val message: String) : State<T>()


    fun isLoading(): Boolean = this is Loading

    fun isSuccessful(): Boolean = this is Loaded

    fun isFailed(): Boolean = this is Error

    companion object {
        private fun <T> success(data: T) =
            Loaded(data)

        private fun <T> error(message: String) =
            Error<T>(message)

        fun <T> fromResource(resource: Resource<T>): State<T> = when (resource) {
            is Resource.Success -> success(resource.data)
            is Resource.Failed -> error(resource.message)
        }
    }
}
