package com.example.kotlinbaseprojectwithnavigation.service.model

import com.google.gson.annotations.SerializedName

data class ApiResponse(
    @SerializedName("success") val success: Boolean,
    @SerializedName("message") val message: String,
    @SerializedName("data") val dataList: List<Company>
)

data class Company (
    @SerializedName("companyId") val companyId: Int,
    @SerializedName("name") val name: String
)

data class User (
    @SerializedName("userId") val userId: Int,
    @SerializedName("employeeId") val employeeId: String,
    @SerializedName("department") val department: String,
    @SerializedName("name") val name: String,
    @SerializedName("phoneNumber") val phoneNumber: String,
    @SerializedName("defaultCarId") val defaultCarId: Int,
)