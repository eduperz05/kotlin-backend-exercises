package com.bcnc.telefonica.kotlinbackendexercises.albums.domain.dto

data class PhotoDto(
    val id: Int,
    val title: String,
    val url: String,
    val thumbnailUrl: String
)
