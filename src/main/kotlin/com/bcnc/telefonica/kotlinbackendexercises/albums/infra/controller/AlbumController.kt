package com.bcnc.telefonica.kotlinbackendexercises.albums.infra.controller

import com.bcnc.telefonica.kotlinbackendexercises.albums.application.service.AlbumService
import com.bcnc.telefonica.kotlinbackendexercises.albums.domain.model.Album
import com.bcnc.telefonica.kotlinbackendexercises.albums.domain.model.Photo
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/albums")
class AlbumController(private val albumService: AlbumService) {

    @GetMapping
    fun getAllAlbums(): ResponseEntity<List<Album>> {
        return ResponseEntity.ok(albumService.getAllAlbums())
    }

    @GetMapping("/{albumId}/photos")
    fun getPhotosByAlbumId(@PathVariable albumId: Int): ResponseEntity<List<Photo>> {
        return ResponseEntity.ok(albumService.getPhotosByAlbumId(albumId))
    }
}
