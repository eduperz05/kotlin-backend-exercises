package com.bcnc.telefonica.kotlinbackendexercises.albums.application.service

import com.bcnc.telefonica.kotlinbackendexercises.albums.application.repository.AlbumRepository
import com.bcnc.telefonica.kotlinbackendexercises.albums.domain.model.Album
import com.bcnc.telefonica.kotlinbackendexercises.albums.domain.model.Photo
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.springframework.web.client.RestTemplate

class AlbumServiceTest {

    @Mock
    lateinit var albumRepository: AlbumRepository

    @InjectMocks
    lateinit var albumService: AlbumService

    @BeforeEach
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun `getAllAlbums returns an empty list when no albums are found`() {
        `when`(albumRepository.fetchAllAlbums()).thenReturn(emptyList())

        val result = albumService.getAllAlbums()

        assertTrue(result.isEmpty())
    }

    @Test
    fun `getAllAlbums returns a list of albums`() {
        val mockAlbums = listOf(Album(1, 1, "Test Album"))
        `when`(albumRepository.fetchAllAlbums()).thenReturn(mockAlbums)

        val result = albumService.getAllAlbums()

        assertEquals(mockAlbums, result)
    }

    @Test
    fun `getPhotosByAlbumId returns an empty list when no photos are found for an album`() {
        `when`(albumRepository.fetchPhotosByAlbumId(1)).thenReturn(emptyList())

        val result = albumService.getPhotosByAlbumId(1)

        assertTrue(result.isEmpty())
    }

    @Test
    fun `getPhotosByAlbumId returns a list of photos for a specific album`() {
        val mockPhotos = listOf(Photo(1, 1, "Test Photo", "http://example.com/photo.jpg", "http://example.com/thumb.jpg"))
        `when`(albumRepository.fetchPhotosByAlbumId(1)).thenReturn(mockPhotos)

        val result = albumService.getPhotosByAlbumId(1)

        assertEquals(mockPhotos, result)
    }
}