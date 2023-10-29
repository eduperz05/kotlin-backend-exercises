package com.bcnc.telefonica.kotlinbackendexercises.albums.application.service

import com.bcnc.telefonica.kotlinbackendexercises.albums.domain.model.Album
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.springframework.web.client.RestTemplate

class AlbumServiceTest {

    @Mock
    lateinit var restTemplate: RestTemplate
    @InjectMocks
    lateinit var albumService: AlbumService

    @BeforeEach
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun `getAllAlbums returns a list of albums`() {
        val mockAlbums = listOf(Album(1, 1, "Test Album"))
        `when`(restTemplate.getForObject("https://jsonplaceholder.typicode.com/albums", Array<Album>::class.java))
            .thenReturn(mockAlbums.toTypedArray())

        val result = albumService.getAllAlbums()

        assertEquals(mockAlbums, result)
    }

    @Test
    fun getPhotosByAlbumId() {
    }
}