package com.bcnc.telefonica.kotlinbackendexercises.albums.domain.usecase

import com.bcnc.telefonica.kotlinbackendexercises.albums.domain.model.Album
import com.bcnc.telefonica.kotlinbackendexercises.albums.domain.model.Photo

interface GetInfoFromAlbums {
    fun getAllAlbums(): List<Album>
    fun getPhotosByAlbumId(albumId: Int): List<Photo>
}