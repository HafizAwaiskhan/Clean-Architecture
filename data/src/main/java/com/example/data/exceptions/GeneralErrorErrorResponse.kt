package com.example.data.exceptions

data class GeneralErrorErrorResponse(
    val key: String?,
    val value: String?
) {
    override fun toString(): String {
        if (value != null)
            return value
        else
            return ""
    }
}