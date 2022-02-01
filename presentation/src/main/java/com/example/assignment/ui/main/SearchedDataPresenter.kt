package nl.zoofy.mobile.ui.auth.signup.company

import android.util.Log
import com.example.assignment.mvp.BaseMvpPresenter
import com.example.domain.interactors.main.MainInteractor
import com.example.domain.models.ResponseFromApi
import com.example.domain.utils.Either
import kotlinx.coroutines.launch

class SearchedDataPresenter(
    private val mainInteractor: MainInteractor
) : BaseMvpPresenter<SearchedDataView>() {
    lateinit var responseFromApi: ResponseFromApi

    override fun attachView(view: SearchedDataView?) {
        super.attachView(view)
    }

    fun getData() {
        launch {
            when (val result = mainInteractor.getData("all-sections" , "7")) {
                is Either.Left -> {
                    Log.d("Error", result.a.toString())
                }
                is Either.Right -> {
                    responseFromApi = result.b
                    viewState.showData(responseFromApi)
                }
            }
        }
    }

    fun doneBtnClicked() {
    }
}