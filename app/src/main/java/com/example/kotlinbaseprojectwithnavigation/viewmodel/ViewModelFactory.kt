package com.example.kotlinbaseprojectwithnavigation.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kotlinbaseprojectwithnavigation.service.network.RetrofitInstance
import com.example.kotlinbaseprojectwithnavigation.service.repository.MainRepository

class ViewModelFactory(val application: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val apiService = RetrofitInstance.apiService
        val mainRepository = MainRepository.getInstance(apiService)

        return when {
            modelClass.isAssignableFrom(MainViewModel::class.java) -> MainViewModel(
                application,
                mainRepository
            ) as T

            modelClass.isAssignableFrom(FirstViewModel::class.java) -> FirstViewModel(
                application,
                mainRepository
            ) as T

            modelClass.isAssignableFrom(SecondViewModel::class.java) -> SecondViewModel(
                application,
                mainRepository
            ) as T

            else -> {
                throw IllegalArgumentException("ViewModel Not Found")
            }
        }
    }
}