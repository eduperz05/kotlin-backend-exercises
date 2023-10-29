package com.bcnc.telefonica.kotlinbackendexercises.albums.application.service

import com.bcnc.telefonica.kotlinbackendexercises.albums.application.repository.AlbumRepository
import com.bcnc.telefonica.kotlinbackendexercises.albums.domain.model.Album
import com.bcnc.telefonica.kotlinbackendexercises.albums.domain.model.Photo
import com.bcnc.telefonica.kotlinbackendexercises.albums.domain.usecase.GetInfoFromAlbums
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate


@Service
class AlbumService(private val albumRepository: AlbumRepository) : GetInfoFromAlbums {

    override fun getAllAlbums(): List<Album> {
        return albumRepository.fetchAllAlbums()
    }

    override fun getPhotosByAlbumId(albumId: Int): List<Photo> {
        return albumRepository.fetchPhotosByAlbumId(albumId)
    }
}