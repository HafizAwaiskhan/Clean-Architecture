package com.example.assignmentshopdev.ui.main

import android.content.Context
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.assignmentshopdev.R
import com.example.assignmentshopdev.mvp.BaseMvpActivity
import java.util.*


class SearchedDataActivity : BaseMvpActivity() {

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    lateinit var mContext: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_searched_data)
        mContext = this

        // Setup navigation only when activity
        // started for the first time
        if (savedInstanceState == null) {
            setUpNavigation()
        } // Else wait until state will be restored
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        // Setup navigation after state was restored
        setUpNavigation()
    }

    private fun setUpNavigation() {

        // Find nav controller and add destination change listener
            navController = findNavController(R.id.navHostFragment)



        // Create app bar configuration
        appBarConfiguration = AppBarConfiguration.Builder(navController.graph).build()

        // Setup action bar with navigation controller
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

}


