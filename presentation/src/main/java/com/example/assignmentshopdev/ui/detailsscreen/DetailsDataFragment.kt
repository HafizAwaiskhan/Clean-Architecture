package com.example.assignmentshopdev.ui.detailsscreen

import android.os.Bundle
import androidx.navigation.fragment.navArgs
import com.example.assignmentshopdev.R
import com.example.assignmentshopdev.mvp.BaseMvpFragment
import kotlinx.android.synthetic.main.details_view.*
import moxy.ktx.moxyPresenter


class DetailsDataFragment :
    BaseMvpFragment(R.layout.details_view),
    DetailsDataView {
    val args: DetailsDataFragmentArgs by navArgs()

    private val presenter by moxyPresenter {
        DetailsDataPresenter()
    }

    override fun setUpViews(savedInstanceState: Bundle?) {

    setUpUILabels()

    }


    override fun setUpUILabels() {
        if (args.detailData != null){
            tvTitle.text = args.detailData.title
            tvDesc.text = args.detailData.abstract
            tvDetails.text = args.detailData.source
            tvMore.text = args.detailData.published_date
        }
    }

}