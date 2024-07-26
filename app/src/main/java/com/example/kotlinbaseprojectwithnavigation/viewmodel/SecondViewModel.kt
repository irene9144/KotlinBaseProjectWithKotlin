package com.example.kotlinbaseprojectwithnavigation.viewmodel

import android.app.Application
import com.example.kotlinbaseprojectwithnavigation.base.BaseViewModel
import com.example.kotlinbaseprojectwithnavigation.service.repository.MainRepository

class SecondViewModel(application: Application, private val mainRepository: MainRepository) :
    BaseViewModel(application) {
}