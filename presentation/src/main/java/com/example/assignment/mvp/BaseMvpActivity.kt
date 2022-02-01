package com.example.assignment.mvp

import android.content.res.Configuration
import android.os.Bundle
import androidx.annotation.IdRes
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import com.example.assignment.R
import moxy.MvpAppCompatActivity


abstract class BaseMvpActivity : MvpAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setLanguage()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        baseContext.resources.updateConfiguration(newConfig, baseContext.resources.displayMetrics)

    }

    fun setLanguage() {}

    /**
     * Navigate to the new destination by the provided destination id
     *
     * @param destinationId destination id redirect to
     */
    protected fun navigate(@IdRes destinationId: Int) {
        try {
            findNavController(R.id.navHostFragment).navigate(destinationId)
        } catch (e: IllegalArgumentException) {
        }
    }

    /**
     * Navigate to the provided destination
     *
     * @param direction destination redirect to
     */
    protected fun navigate(direction: NavDirections) {
        try {
            findNavController(R.id.navHostFragment).navigate(direction)
        } catch (e: IllegalArgumentException) {
        }
    }

    /**
     * Navigate to the previous destination
     */
    protected fun navigateBack() {
        try {
            findNavController(R.id.navHostFragment).popBackStack()
        } catch (e: IllegalArgumentException) {
        }
    }
}