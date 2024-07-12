package com.example.kotlinbaseprojectwithnavigation.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.viewbinding.ViewBinding
import com.example.kotlinbaseprojectwithnavigation.viewmodel.ViewModelFactory

/*
ver 1 abstract class BaseActivity<B : ViewBinding, V : BaseViewModel>(@LayoutRes private val layoutId: Int) :
    AppCompatActivity(), BaseFragment.CallBack {}
* */
abstract class BaseActivity<B : ViewBinding, V : BaseViewModel>(val bindingFactory: (LayoutInflater) -> B) :
    AppCompatActivity(), BaseFragment.CallBack {
    private var _binding: B? = null
    val mBinding get() = _binding!!
    protected var mViewModel: V? = null

    //    @LayoutRes
//    abstract fun getLayoutId(): Int
    protected abstract fun initViews()
    protected abstract fun setupNavigation()
    protected abstract fun getViewModelClass(): Class<V>
    protected abstract fun observeViewModel()
    protected open fun initViewModel() {
        val factory = ViewModelFactory(application)
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

    abstract fun getBindingVariable(): Int
    protected open fun initListener() { }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // mBinding = DataBindingUtil.setContentView(this, layoutId)
        _binding = bindingFactory(layoutInflater)
        setContentView(mBinding.root)

        initViews()
        initViewModel()
        initListener()

    }

    override fun onResume() {
        super.onResume()

    }
    override fun onStart() {
        super.onStart()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    protected fun addFragment(fragment: BaseFragment<*,*>, containerId: Int) {
        supportFragmentManager.beginTransaction().apply {
            add(containerId, fragment)
            commit()
        }
    }


    protected fun replaceFragment(fragment: BaseFragment<*,*>, containerId: Int) {
        supportFragmentManager.beginTransaction().apply {
            replace(containerId, fragment)
            commit()
        }
    }

    override fun onFragmentAttached() {
    }

    override fun onFragmentDetached(tag: String) {
    }
}