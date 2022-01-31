package com.example.data.api

import retrofit2.Call
import com.example.domain.models.ResponseFromApi
import retrofit2.http.*


/**
 * API Interface
 * All possible API calls will be here
 */
interface Api {


    /**
     * API call to Get Data
     * all-sections/7.json?api-key=01Qm70H2tIHGe5T05H7bPx3pP4AVgFLh
     */
    @GET("{section}/{period}.json?api-key=01Qm70H2tIHGe5T05H7bPx3pP4AVgFLh")
    fun getData(
        @Path("section") section : String,
        @Path("period") period : String
    ): Call<ResponseFromApi>

}