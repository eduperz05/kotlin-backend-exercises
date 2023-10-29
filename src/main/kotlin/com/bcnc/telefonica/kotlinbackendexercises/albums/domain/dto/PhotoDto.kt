package com.bcnc.telefonica.kotlinbackendexercises.albums.domain.dto

data class PhotoDto(
    val id: Int = 0,
    val title: String = "",
    val url: String = "",
    val thumbnailUrl: String = ""
)
