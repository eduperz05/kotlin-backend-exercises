package com.bcnc.telefonica.kotlinbackendexercises.albums.domain.model

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class AlbumTest {

    @Test
    fun `belongsToUser returns true if album belongs to user`() {
        val album = Album(userId = 1, id = 10, title = "Test Album")
        assertTrue(album.belongsToUser(1))
    }
}