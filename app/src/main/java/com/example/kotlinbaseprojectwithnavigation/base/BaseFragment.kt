package com.example.kotlinbaseprojectwithnavigation.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.viewbinding.ViewBinding
import com.example.kotlinbaseprojectwithnavigation.viewmodel.ViewModelFactory

/*
ver 1 :: abstract class BaseFragment<T : ViewBinding, V : BaseViewModel>(@LayoutRes private val layoutId: Int) :
    Fragment(){}
* */

abstract class BaseFragment<T : ViewBinding, V : ViewModel> :
    Fragment() {

    //    protected lateinit var mBinding: T
    interface CallBack {
        fun onFragmentAttached()
        fun onFragmentDetached(tag: String)
    }

    private var _binding: T? = null
    val mBinding get() = _binding!!

    protected var mViewModel: V? = null
    private var mActivity: BaseActivity<*, *>? = null

    //    @LayoutRes
//    abstract fun getLayoutId(): Int
    abstract fun initViews()
    abstract fun getViewModelClass(): Class<V>
    abstract fun observeViewModel()

    protected open fun initViewModel() {
        val factory = ViewModelFactory(requireActivity().application)
        mViewModel = ViewModelProvider(this, factory)[getViewModelClass()]
    }

    /*
    * 구현해야하는 abstract fun initView()  또는 상속할 수 있도록 protected open initView() -> 생각해봐야함.
    *
    * protected open fun afterViewCreated(){}
    * protected open fun initListener(){}
    * protected open fun initViewModel(){}
    * protected open fun initView(){}
    *
    *
    * */


    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is BaseActivity<*, *>) {
            mActivity = context
            mActivity?.onFragmentAttached()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // ver1: mBinding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        _binding = getFragmentBinding(inflater, container)
        return mBinding.root
    }

    abstract fun getFragmentBinding(inflater: LayoutInflater, container: ViewGroup?): T

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initViewModel()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}