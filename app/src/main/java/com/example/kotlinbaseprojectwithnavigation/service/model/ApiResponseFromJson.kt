package com.example.kotlinbaseprojectwithnavigation.service.model

data class ApiResponseFromJson(
    val data: List<Company>,
    val message: String,
    val success: Boolean
)

data class ApiUserResponseFromJson(
    //val data: List<Company>,
    val data: List<User>,
    val message: String,
    val success: Boolean
)