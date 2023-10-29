package com.bcnc.telefonica.kotlinbackendexercises.albums.application.mapper

import com.bcnc.telefonica.kotlinbackendexercises.albums.domain.dto.PhotoDto
import com.bcnc.telefonica.kotlinbackendexercises.albums.domain.model.Photo
import org.modelmapper.ModelMapper
import org.springframework.stereotype.Component

object PhotoMapper {

    fun mapToPhoto(photoDto: PhotoDto, albumId: Int): Photo {
        return Photo(
            albumId = albumId,
            id = photoDto.id,
            title = photoDto.title,
            url = photoDto.url,
            thumbnailUrl = photoDto.thumbnailUrl
        )
    }

    fun mapToPhotoDto(photo: Photo): PhotoDto {
        return PhotoDto(
            id = photo.id,
            title = photo.title,
            url = photo.url,
            thumbnailUrl = photo.thumbnailUrl
        )
    }
}
