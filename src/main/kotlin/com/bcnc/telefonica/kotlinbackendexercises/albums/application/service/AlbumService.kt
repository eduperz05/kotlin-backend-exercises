package com.bcnc.telefonica.kotlinbackendexercises.albums.application.service

import com.bcnc.telefonica.kotlinbackendexercises.albums.domain.model.Album
import com.bcnc.telefonica.kotlinbackendexercises.albums.domain.model.Photo
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate


@Service
class AlbumService {

    private val restTemplate = RestTemplate()
    private val baseUrl = "https://jsonplaceholder.typicode.com"

    fun getAllAlbums(): List<Album> {
        val url = "$baseUrl/albums"
        return restTemplate.getForObject(url, Array<Album>::class.java)?.toList() ?: emptyList()
    }

    fun getPhotosByAlbumId(albumId: Int): List<Photo> {
        val url = "$baseUrl/albums/$albumId/photos"
        return restTemplate.getForObject(url, Array<Photo>::class.java)?.toList() ?: emptyList()
    }
}