package com.example.kotlinbaseprojectwithnavigation.view.ui

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.util.Log
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.kotlinbaseprojectwithnavigation.R
import com.example.kotlinbaseprojectwithnavigation.base.BaseActivity
import com.example.kotlinbaseprojectwithnavigation.databinding.ActivityMainBinding
import com.example.kotlinbaseprojectwithnavigation.viewmodel.MainViewModel
import com.google.android.material.navigationrail.NavigationRailView

class MainActivity :
    BaseActivity<ActivityMainBinding, MainViewModel>({ ActivityMainBinding.inflate(it) }) {

//    private val TAG

//    protected lateinit var navController: NavController
//
//    private val appBarConfiguration by lazy {
//        AppBarConfiguration(
//            setOf(
//                R.id.first_fragment, R.id.second_fragment
//            ),
//            mBinding.drawerLayout
//        )
//    }


    override fun initViews() {
        setupNavigation()
    }

    override fun setupNavigation() {
//        val navHostFragment = supportFragmentManager
//            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
//        navController = navHostFragment.navController
//
//
//        setSupportActionBar(mBinding.toolbar)
//        setupActionBarWithNavController(navController, appBarConfiguration)
//        mBinding.bottomNavigation.setupWithNavController(navController)
//        mBinding.sideNavigation.setupWithNavController(navController)

// 세로 Navigation Bar
        val navController = (supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment).navController
        val navigationRailView: NavigationRailView = mBinding.navigationRail
        NavigationUI.setupWithNavController(navigationRailView, navController)

        navigationRailView.headerView?.setOnClickListener {
            Toast.makeText(this, "Replace this with your own action", Toast.LENGTH_LONG).show()
        }
    }
    private fun isNetworkAvailabable(): Boolean {
        val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE)
                as ConnectivityManager

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val nw = connectivityManager.activeNetwork ?: return false
            val actNw = connectivityManager.getNetworkCapabilities(nw) ?: return false
            return when {
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                    Log.d("smkwon", "wifi available")
                    true
                }
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
                    Log.d("smkwon", "cellular available")
                    true
                }
                else -> false
            }
        } else {
            return connectivityManager.isDefaultNetworkActive
        }
    }
//    override fun onSupportNavigateUp(): Boolean {
//        return navController.navigateUp() || super.onSupportNavigateUp()
//    }

    override fun getViewModelClass(): Class<MainViewModel> = MainViewModel::class.java


    override fun observeViewModel() {

    }

    override fun getBindingVariable(): Int {
        return 0
    }

}

