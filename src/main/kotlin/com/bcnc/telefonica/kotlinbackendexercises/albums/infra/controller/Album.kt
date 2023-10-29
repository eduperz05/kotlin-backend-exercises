package com.bcnc.telefonica.kotlinbackendexercises.albums.infra.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/albums")
class Album {

    @GetMapping
    fun getAlbums(): String {
        return "Albums"
    }
}