package com.bcnc.telefonica.kotlinbackendexercises.albums.domain.model

data class Photo(
    val albumId: Int,
    val id: Int,
    val title: String,
    val url: String,
    val thumbnailUrl: String
) {
    fun belongsToAlbum(albumId: Int): Boolean {
        return this.albumId == albumId
    }

    fun hasValidUrl(): Boolean {
        return url.startsWith("http://") || url.startsWith("https://")
    }
}

