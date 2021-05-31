package com.jose.photoalbum.model

data class PhotoModel(
    val albumId: Long,
    val id: Long,

    val title: String,
    val url: String,
    val thumbnailUrl: String
)