package com.example.kotlinbaseprojectwithnavigation.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelFactory(val application: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MainViewModel::class.java) -> {
                MainViewModel(application) as T
            }

            modelClass.isAssignableFrom(FirstViewModel::class.java) -> {
                FirstViewModel(application) as T
            }

            modelClass.isAssignableFrom(SecondViewModel::class.java) -> {
                SecondViewModel(application) as T
            }

            else -> {
                throw IllegalArgumentException("ViewModel Not Found")
            }
        }
    }
}