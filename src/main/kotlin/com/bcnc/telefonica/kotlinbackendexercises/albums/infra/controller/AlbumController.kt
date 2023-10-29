package com.bcnc.telefonica.kotlinbackendexercises.albums.infra.controller

import com.bcnc.telefonica.kotlinbackendexercises.albums.application.mapper.AlbumMapper
import com.bcnc.telefonica.kotlinbackendexercises.albums.application.mapper.PhotoMapper
import com.bcnc.telefonica.kotlinbackendexercises.albums.application.service.AlbumService
import com.bcnc.telefonica.kotlinbackendexercises.albums.domain.dto.AlbumDto
import com.bcnc.telefonica.kotlinbackendexercises.albums.domain.model.Photo
import org.modelmapper.ModelMapper
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/albums")
class AlbumController(private val albumService: AlbumService,
                      private val modelMapper: ModelMapper
) {

    @GetMapping
    fun getAllAlbums(): ResponseEntity<List<AlbumDto>> {
        val albumDtos = albumService.getAllAlbums().map { album -> AlbumMapper(modelMapper).mapToAlbumDto(album) }
        return ResponseEntity.ok(albumDtos)
    }


    @GetMapping("/{albumId}/photos")
    fun getPhotosByAlbumId(@PathVariable albumId: Int): ResponseEntity<List<Photo>> {
        val photoDtos = albumService.getPhotosByAlbumId(albumId).map { photo -> PhotoMapper(modelMapper).mapToPhotoDto(photo) }
        return ResponseEntity.ok(albumService.getPhotosByAlbumId(albumId))
    }
}
