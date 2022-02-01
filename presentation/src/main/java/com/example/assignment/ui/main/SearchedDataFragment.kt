package com.example.assignment.ui.main

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assignment.R
import com.example.assignment.mvp.BaseMvpFragment
import com.example.domain.interactors.main.MainInteractor
import com.example.domain.models.ResponseFromApi
import com.example.domain.models.Result
import kotlinx.android.synthetic.main.recyclerview_layout.*
import moxy.ktx.moxyPresenter
import nl.zoofy.mobile.ui.auth.signup.company.SearchedDataPresenter
import nl.zoofy.mobile.ui.auth.signup.company.SearchedDataView
import org.koin.android.ext.android.inject


class SearchedDataFragment :
    BaseMvpFragment(R.layout.recyclerview_layout),
    SearchedDataView {

    private val mainInteractor: MainInteractor by inject()

    private val presenter by moxyPresenter {
        SearchedDataPresenter(mainInteractor = mainInteractor)
    }

    private val searchedDataAdapter = SearchedDataAdapter(::searchDataClick)

    override fun setUpViews(savedInstanceState: Bundle?) {

        search_recycler_view.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        search_recycler_view.adapter = searchedDataAdapter

    }

    override fun setUpUILabels() {
        // update the UI labels
    }

    override fun onResume() {
        super.onResume()
        presenter.getData()
    }

    override fun goNext() {
    }

    override fun showData(responseFromApi: ResponseFromApi) {
        searchedDataAdapter.setData(responseFromApi)
    }

    /**
     * after clicking on data show details screen
     */

    private fun searchDataClick(data: Result) {
        if (data.title.isNotEmpty()) {
            navigate(SearchedDataFragmentDirections.mainToDetails(data))
        }

    }

}