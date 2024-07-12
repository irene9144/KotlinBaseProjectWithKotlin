package com.example.kotlinbaseprojectwithnavigation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import com.example.kotlinbaseprojectwithnavigation.base.BaseFragment
import com.example.kotlinbaseprojectwithnavigation.databinding.FirstFragmentBinding
import com.example.kotlinbaseprojectwithnavigation.viewmodel.FirstViewModel
import com.example.kotlinbaseprojectwithnavigation.viewmodel.ViewModelFactory

class FirstFragment :
    BaseFragment<FirstFragmentBinding, FirstViewModel>() {
    private val viewModel: FirstViewModel by viewModels { ViewModelFactory(requireActivity().application) }

    override fun initViews() {
        onCreateOnMove()
    }

    override fun getViewModelClass(): Class<FirstViewModel> =  FirstViewModel::class.java


    override fun observeViewModel() {
    }

    private fun onCreateOnMove() {
      //  findNavController().navigate(FirstFragmentDirections.actionFirstFragmentToSecondFragment())

    }


    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FirstFragmentBinding {
        return FirstFragmentBinding.inflate(inflater, container, false
        )
    }
}