package com.example.assignmentshopdev.mvp

import android.os.Bundle
import android.view.View
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import moxy.MvpAppCompatFragment

abstract class BaseMvpFragment(
    @LayoutRes layoutId: Int
) : MvpAppCompatFragment(layoutId), BaseMvpView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val currentActivity = activity ?: return
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Call specific method to set up views
        setUpViews(savedInstanceState)
    }

    /**
     * Should be implemented be child view to be able
     * to set up views (add listeners)
     */
    abstract fun setUpViews(savedInstanceState: Bundle?)


    /**
     * Should be implemented be child view to be able
     * to set up Language change or text update
     */
    abstract fun setUpUILabels()

    /**
     * Navigate to the new destination by the provided destination id
     * Child should override this method for specific realization
     *
     * @param destinationId destination id redirect to
     */
    protected fun navigate(@IdRes destinationId: Int) {
        try {
            findNavController().navigate(destinationId)
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
            findNavController().navigate(direction)
        } catch (e: IllegalArgumentException) {

        }
    }

    /**
     * Navigate to the previous destination
     */
    protected fun navigateBack() {
        try {
            findNavController().popBackStack()
        } catch (e: IllegalArgumentException) {

        }
    }

    /**
     * Navigate to the previous destination
     *
     *  @param destinationId destination navigate back to
     */
    protected fun navigateBack(@IdRes destinationId: Int, inclusive: Boolean = false) {
        try {
            findNavController().popBackStack(destinationId, inclusive)
        } catch (e: IllegalArgumentException) {

        }
    }
}