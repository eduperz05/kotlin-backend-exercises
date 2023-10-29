package com.bcnc.telefonica.kotlinbackendexercises.albums.application.service

import com.bcnc.telefonica.kotlinbackendexercises.albums.application.repository.AlbumRepository
import com.bcnc.telefonica.kotlinbackendexercises.albums.domain.model.Album
import com.bcnc.telefonica.kotlinbackendexercises.albums.domain.model.Photo
import com.bcnc.telefonica.kotlinbackendexercises.albums.domain.usecase.GetInfoFromAlbums
import com.bcnc.telefonica.kotlinbackendexercises.albums.infra.exception.AlbumNotFound
import org.springframework.stereotype.Service


@Service
class AlbumService(private val albumRepository: AlbumRepository) : GetInfoFromAlbums {

    override fun getAllAlbums(): List<Album> {
        return albumRepository.fetchAllAlbums()
    }

    override fun getPhotosByAlbumId(albumId: Int): List<Photo> {
        val photos = albumRepository.fetchPhotosByAlbumId(albumId)
        if (photos.isEmpty()) {
            throw AlbumNotFound("No photos found for album ID: $albumId")
        }
        return photos
    }
}