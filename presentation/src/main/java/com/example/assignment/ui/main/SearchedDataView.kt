package nl.zoofy.mobile.ui.auth.signup.company

import com.example.assignment.mvp.BaseMvpView
import com.example.domain.models.ResponseFromApi
import moxy.viewstate.strategy.alias.Skip

interface SearchedDataView : BaseMvpView {

    @Skip
    fun showData(responseFromApi: ResponseFromApi)

    @Skip
    fun goNext()

}