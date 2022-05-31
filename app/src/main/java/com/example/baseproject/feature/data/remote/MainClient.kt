package com.example.baseproject.feature.data.remote

import com.example.baseproject.core.base.BaseClient
import com.example.baseproject.feature.data.model.rickandmorty.Characters
import retrofit2.Response
import javax.inject.Inject

class MainClient @Inject constructor(
    private val mainService: MainService
): BaseClient() {
    private var page: Int = 0
    suspend fun getApiData(): Response<Characters> {
        return mainService.getDataFromAPI(getPageData())
    }
    private fun getPageData() = page++  // call page with start one to end page by using ++
}