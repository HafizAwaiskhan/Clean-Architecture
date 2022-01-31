package com.example.domain.models

data class ResponseFromApi(
    val copyright: String,
    val num_results: Int,
    val results: List<Result>,
    val status: String
)