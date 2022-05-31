package com.example.baseproject.feature.data.remote

import com.example.baseproject.feature.data.model.rickandmorty.Characters
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MainService {

    @GET("character/")
    suspend fun getDataFromAPI(@Query("page") query: Int): Response<Characters>
}