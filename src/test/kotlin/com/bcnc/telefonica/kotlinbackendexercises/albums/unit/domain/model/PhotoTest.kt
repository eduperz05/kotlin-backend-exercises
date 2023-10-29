package com.bcnc.telefonica.kotlinbackendexercises.albums.unit.domain.model

import com.bcnc.telefonica.kotlinbackendexercises.albums.domain.model.Photo
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class PhotoTest {

    @Test
    fun `belongsToAlbum returns true if photo belongs to album`() {
        val photo = Photo(albumId = 5, id = 50, title = "Test Photo", url = "http://example.com/photo.jpg",
            thumbnailUrl = "http://example.com/thumb.jpg")
        assertTrue(photo.belongsToAlbum(5))
    }

    @Test
    fun `hasValidUrl returns true if photo URL is valid`() {
        val photo = Photo(albumId = 5, id = 50, title = "Test Photo", url = "http://example.com/photo.jpg",
            thumbnailUrl = "http://example.com/thumb.jpg")
        assertTrue(photo.hasValidUrl())
    }
}
