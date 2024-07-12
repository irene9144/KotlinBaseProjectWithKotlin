package com.example.kotlinbaseprojectwithnavigation.view.ui.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.kotlinbaseprojectwithnavigation.base.BaseFragment
import com.example.kotlinbaseprojectwithnavigation.databinding.SecondFragmentBinding
import com.example.kotlinbaseprojectwithnavigation.viewmodel.SecondViewModel
import com.example.kotlinbaseprojectwithnavigation.viewmodel.ViewModelFactory

class SecondFragment :
    BaseFragment<SecondFragmentBinding, SecondViewModel>() {
    private val viewModel: SecondViewModel by viewModels { ViewModelFactory(requireActivity().application) }

    override fun initViews() {
    }

    override fun getViewModelClass(): Class<SecondViewModel> =  SecondViewModel::class.java


    override fun observeViewModel() {
    }

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): SecondFragmentBinding {
        return SecondFragmentBinding.inflate(inflater, container, false
        )
    }
}