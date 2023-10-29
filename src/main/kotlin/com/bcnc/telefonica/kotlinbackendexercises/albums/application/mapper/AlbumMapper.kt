package com.bcnc.telefonica.kotlinbackendexercises.albums.application.mapper

import com.bcnc.telefonica.kotlinbackendexercises.albums.domain.dto.AlbumDto
import com.bcnc.telefonica.kotlinbackendexercises.albums.domain.model.Album

object AlbumMapper {

    fun mapToAlbum(albumDto: AlbumDto, userId: Int): Album {
        return Album(
            userId = userId,
            id = albumDto.id,
            title = albumDto.title
        )
    }

    fun mapToAlbumDto(album: Album): AlbumDto {
        return AlbumDto(
            id = album.id,
            title = album.title
        )
    }
}
