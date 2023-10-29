package com.bcnc.telefonica.kotlinbackendexercises.albums.application.mapper

import com.bcnc.telefonica.kotlinbackendexercises.albums.domain.dto.PhotoDto
import com.bcnc.telefonica.kotlinbackendexercises.albums.domain.model.Photo
import org.modelmapper.ModelMapper
import org.springframework.stereotype.Component

@Component
class PhotoMapper(private val modelMapper: ModelMapper) {

    fun mapToPhoto(photo: PhotoDto): Photo {
        return modelMapper.map(photo, Photo::class.java)
    }

    fun mapToPhotoDto(photo: Photo): PhotoDto {
        return modelMapper.map(photo, PhotoDto::class.java)
    }
}