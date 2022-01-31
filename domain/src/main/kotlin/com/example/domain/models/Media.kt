package com.example.domain.models

data class Media(
    val approved_for_syndication: Int,
    val caption: String,
    val copyright: String,
    val media_metadata: List<MediaMetadata>,
    val subtype: String,
    val type: String
)