package com.bcnc.telefonica.kotlinbackendexercises.albums.infra.adapter

import com.bcnc.telefonica.kotlinbackendexercises.albums.application.repository.AlbumRepository
import com.bcnc.telefonica.kotlinbackendexercises.albums.domain.model.Album
import com.bcnc.telefonica.kotlinbackendexercises.albums.domain.model.Photo
import org.springframework.stereotype.Repository
import org.springframework.web.client.RestTemplate

@Repository
class JsonPlaceholderAlbum(private val restTemplate: RestTemplate) : AlbumRepository {

    private val baseUrl = "https://jsonplaceholder.typicode.com"

    override fun fetchAllAlbums(): List<Album> {
        val url = "$baseUrl/albums"
        return restTemplate.getForObject(url, Array<Album>::class.java)?.toList() ?: emptyList()
    }

    override fun fetchPhotosByAlbumId(albumId: Int): List<Photo> {
        val url = "$baseUrl/albums/$albumId/photos"
        return restTemplate.getForObject(url, Array<Photo>::class.java)?.toList() ?: emptyList()
    }
}