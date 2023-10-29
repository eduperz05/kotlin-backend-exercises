package com.bcnc.telefonica.kotlinbackendexercises.albums.unit.service

import com.bcnc.telefonica.kotlinbackendexercises.albums.application.repository.AlbumRepository
import com.bcnc.telefonica.kotlinbackendexercises.albums.application.service.AlbumService
import com.bcnc.telefonica.kotlinbackendexercises.albums.domain.model.Album
import com.bcnc.telefonica.kotlinbackendexercises.albums.domain.model.Photo
import com.bcnc.telefonica.kotlinbackendexercises.albums.infra.exception.AlbumNotFound
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

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
    fun `getPhotosByAlbumId throws AlbumNotFound when no photos are found for an album`() {
        `when`(albumRepository.fetchPhotosByAlbumId(1)).thenReturn(emptyList())

        val exception = assertThrows<AlbumNotFound> {
            albumService.getPhotosByAlbumId(1)
        }

        assertEquals("No photos found for album ID: 1", exception.message)
    }


    @Test
    fun `getPhotosByAlbumId returns a list of photos for a specific album`() {
        val mockPhotos = listOf(Photo(1, 1, "Test Photo", "http://example.com/photo.jpg", "http://example.com/thumb.jpg"))
        `when`(albumRepository.fetchPhotosByAlbumId(1)).thenReturn(mockPhotos)

        val result = albumService.getPhotosByAlbumId(1)

        assertEquals(mockPhotos, result)
    }
}