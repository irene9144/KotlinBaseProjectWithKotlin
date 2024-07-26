package com.example.kotlinbaseprojectwithnavigation

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinbaseprojectwithnavigation.base.BaseFragment
import com.example.kotlinbaseprojectwithnavigation.databinding.FirstFragmentBinding
import com.example.kotlinbaseprojectwithnavigation.view.adapters.CompanyListAdapter
import com.example.kotlinbaseprojectwithnavigation.viewmodel.FirstViewModel
import com.example.kotlinbaseprojectwithnavigation.viewmodel.ViewModelFactory

class FirstFragment :
    BaseFragment<FirstFragmentBinding, FirstViewModel>() {

    private lateinit var companyListAdapter: CompanyListAdapter


    override fun initViews() {
        onCreateOnMove()
        companyListAdapter = CompanyListAdapter(listOf())
        mBinding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = companyListAdapter
        }

    }

    override fun getViewModelClass(): Class<FirstViewModel>
    {
        return FirstViewModel::class.java
    }


    override fun observeViewModel() {
        mViewModel?.companyList?.observe(this, Observer{ companyList ->
            Log.e("smkwon_FirstFragment","companyList -- > $companyList")
            mBinding.recyclerView.adapter = CompanyListAdapter(companyList)

            mBinding.recyclerView.adapter?.notifyDataSetChanged()
        })
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