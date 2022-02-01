package com.example.assignment.mvp

import com.example.domain.exception.Failure
import com.example.domain.interactors.main.MainInteractor
import kotlinx.coroutines.CoroutineScope
import moxy.MvpPresenter
import moxy.presenterScope
import org.koin.core.KoinComponent
import org.koin.core.inject
import kotlin.coroutines.CoroutineContext

abstract class BaseMvpPresenter<View : BaseMvpView> :
    MvpPresenter<View>(),
    CoroutineScope,
    KoinComponent {

    private val mainInteractor: MainInteractor by inject()

    override val coroutineContext: CoroutineContext
        get() = presenterScope.coroutineContext

    /**
     * Base implementation of handling @see Failure object
     * that can be returned from the interactors
     *
     * @param failure Failure to handle and show appropriate message to the user
     */
    protected fun showFailure(failure: Failure) {
        when (failure) {

//            is Failure.GeneralError -> viewState.showError(failure.message)
//
//            // Default error
//            else -> viewState.showError(R.string.errorUnknownError.toString())
        }
    }


    fun getFailureMessage(failure: Failure):String {
        when (failure) {
            is Failure.GeneralError -> return failure.message

            // Default error
            else -> return "Error"
        }
    }

    fun getError(a: Failure): String {
        return getFailureMessage(a)
    }


}