package com.example.data.utils

import com.google.gson.Gson
import com.example.data.exceptions.ApiError
import com.example.domain.exception.Failure
import org.json.JSONObject
import retrofit2.Response

private const val MAINTENANCE_ERROR_CODE = 503

fun <T> Response<T>.errorResponse(): Failure {
    return try {

        val errorString = errorBody()?.string()
        var responseJson: JSONObject? = null
        var dummyCode = -1
        var error: ApiError
        try {
            responseJson = JSONObject(errorString)
            dummyCode = responseJson.optInt("code", -1)

        } catch (e: Exception) {
        }
        error = ApiError(
            null,
            null
        )

        if (dummyCode != -1) {

            error.error = responseJson?.optString("error")
        } else {
            if (responseJson != null) {

                val errorObject: JSONObject? = responseJson.optJSONObject("error")
                if (errorObject != null) {
                    error.error = errorObject.optString("message")
                }

            }
            if (error.error == null)
                error = Gson().fromJson(errorString, ApiError::class.java)
        }
        val code = code()

        when {
            error.isDataError() -> Failure.GeneralError(error.getDataError())

            else -> Failure.ServerError
        }
    } catch (e: Exception) {
        Failure.UnknownError
    }
}

fun <T> Response<T>.successResponse(): T {
    try {
        return body()!!
    } catch (e: Exception) {
        throw RuntimeException("Unable to parse success response : $e")
    }
}