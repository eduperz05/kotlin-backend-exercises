package com.bcnc.telefonica.kotlinbackendexercises.albums.integration.application

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
class AlbumControllerIntegrationTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun `getPhotosByAlbumId returns 404 for a non-existent album`() {
        mockMvc.perform(get("/albums/9999/photos"))
            .andExpect(status().isNotFound)
    }

    @Test
    fun `getAllAlbums returns a list of albums`() {
        mockMvc.perform(get("/albums"))
            .andExpect(status().isOk)
    }

    @Test
    fun `getPhotosByAlbumId returns a list of photos for a specific album`() {
        mockMvc.perform(get("/albums/1/photos"))
            .andExpect(status().isOk)
    }

    @Test
    fun `getAllAlbums returns a list of albums with expected structure`() {
        mockMvc.perform(get("/albums"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$[0].id").exists())
            .andExpect(jsonPath("$[0].title").exists())
    }

    @Test
    fun `getPhotosByAlbumId returns a list of photos with expected structure for a specific album`() {
        mockMvc.perform(get("/albums/1/photos"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$[0].id").exists())
            .andExpect(jsonPath("$[0].title").exists())
            .andExpect(jsonPath("$[0].url").exists())
            .andExpect(jsonPath("$[0].thumbnailUrl").exists())
    }
}
