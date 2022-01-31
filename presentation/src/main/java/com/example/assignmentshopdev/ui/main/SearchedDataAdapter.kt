package com.example.assignmentshopdev.ui.main

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.assignmentshopdev.R
import com.example.domain.models.ResponseFromApi
import com.example.domain.models.Result
import kotlinx.android.synthetic.main.rv_search_data.view.*

class SearchedDataAdapter(
    val searchDataClick: (data: Result) -> Unit
) : RecyclerView.Adapter<SearchedDataAdapter.DataViewHolder>() {
    private val data = mutableListOf<Result>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        return DataViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.rv_search_data,
                parent,
                false
            )
        )
    }
    @SuppressLint("NotifyDataSetChanged")
    fun setData(responseFromApi: ResponseFromApi) {
        this.data.clear()
        this.data.addAll(responseFromApi.results)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(data = data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(data: Result) {
            itemView.titleTV.text = data.title

            itemView.setOnClickListener { searchDataClick.invoke(data) }

        }
    }


}