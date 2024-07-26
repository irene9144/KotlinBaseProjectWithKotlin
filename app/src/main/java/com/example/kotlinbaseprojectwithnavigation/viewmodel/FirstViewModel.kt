package com.example.kotlinbaseprojectwithnavigation.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.liveData
import com.example.kotlinbaseprojectwithnavigation.base.BaseViewModel
import com.example.kotlinbaseprojectwithnavigation.service.model.Company
import com.example.kotlinbaseprojectwithnavigation.service.model.User
import com.example.kotlinbaseprojectwithnavigation.service.repository.MainRepository
import kotlinx.coroutines.Dispatchers

class FirstViewModel(application: Application, private val mainRepository: MainRepository) :
    BaseViewModel(application) {

    val companyList = liveData(Dispatchers.IO){
        try {
            val response = mainRepository.getCompanyList()
            Log.e("smkwon_FirstViewModel","$response")
            val companyList = response.body()!!.data

            emit(companyList)

        }catch (e: Exception) {
            emit(emptyList<Company>())
        }
    }

    val userList = liveData(Dispatchers.IO){
        try {
            val response = mainRepository.getUserList()
            Log.e("smkwon_FirstViewModel","$response")
            val userList = response.body()!!.data

            emit(userList)

        }catch (e: Exception) {
            emit(emptyList<User>())
        }
    }
}