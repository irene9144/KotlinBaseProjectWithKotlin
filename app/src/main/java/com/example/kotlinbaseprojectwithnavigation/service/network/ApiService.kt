package com.example.kotlinbaseprojectwithnavigation.service.network

import com.example.kotlinbaseprojectwithnavigation.service.model.ApiResponseFromJson
import com.example.kotlinbaseprojectwithnavigation.service.model.ApiUserResponseFromJson
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("app/v1/company")
    suspend fun getMailList(): Response<ApiResponseFromJson>

    @GET("app/v1/company/{companyId}/users")
    suspend fun getUserList(@Path("companyId") id:Int): Response<ApiUserResponseFromJson>
}