package com.example.data.exceptions


class ApiError(
    val data: List<GeneralErrorErrorResponse>?,
    var error: String?
) {

    fun isDataError(): Boolean = data != null

    fun getDataError(): String {
        var errorResponseString: String = ""
        if (data != null) {

            data.forEach{
                errorResponseString += it.toString() +"\n"
            }
        } else {
            errorResponseString = UNKNOWN_ERROR
        }
        return errorResponseString
    }

    companion object {

        private const val UNKNOWN_ERROR = "Unknown error!"
    }
}