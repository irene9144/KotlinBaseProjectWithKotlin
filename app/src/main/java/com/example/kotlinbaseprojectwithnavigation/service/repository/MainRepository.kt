package com.example.kotlinbaseprojectwithnavigation.service.repository

import com.example.kotlinbaseprojectwithnavigation.service.model.ApiResponseFromJson
import com.example.kotlinbaseprojectwithnavigation.service.model.ApiUserResponseFromJson
import com.example.kotlinbaseprojectwithnavigation.service.network.ApiService
import retrofit2.Response

class MainRepository private constructor(private val apiService: ApiService){
    companion object {
        @Volatile
        private var instance: MainRepository? = null

        fun getInstance(apiService: ApiService) =
            instance ?: synchronized(this) {
                instance ?:MainRepository(apiService).also { instance = it }
            }

    }
    suspend fun getCompanyList(): Response<ApiResponseFromJson> {
        return apiService.getMailList()
    }
    suspend fun getUserList(): Response<ApiUserResponseFromJson>
    {
        return apiService.getUserList(1)
    }
}