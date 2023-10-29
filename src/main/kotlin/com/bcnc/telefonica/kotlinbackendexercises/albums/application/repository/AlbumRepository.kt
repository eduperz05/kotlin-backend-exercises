package com.bcnc.telefonica.kotlinbackendexercises.albums.application.repository

import com.bcnc.telefonica.kotlinbackendexercises.albums.domain.model.Album
import com.bcnc.telefonica.kotlinbackendexercises.albums.domain.model.Photo

interface AlbumRepository {
    fun fetchAllAlbums(): List<Album>
    fun fetchPhotosByAlbumId(albumId: Int): List<Photo>
}