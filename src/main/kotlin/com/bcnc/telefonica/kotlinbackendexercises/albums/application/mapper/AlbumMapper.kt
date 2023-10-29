package com.bcnc.telefonica.kotlinbackendexercises.albums.application.mapper

import com.bcnc.telefonica.kotlinbackendexercises.albums.domain.dto.AlbumDto
import com.bcnc.telefonica.kotlinbackendexercises.albums.domain.model.Album
import org.modelmapper.ModelMapper

class AlbumMapper(private val modelMapper: ModelMapper) {

    fun mapToAlbum(album: AlbumDto): Album {
        return modelMapper.map(album, Album::class.java)
    }

    fun mapToAlbumDto(album: Album): AlbumDto {
        return modelMapper.map(album, AlbumDto::class.java)
    }
}