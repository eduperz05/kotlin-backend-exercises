package com.bcnc.telefonica.kotlinbackendexercises.albums.domain.model

data class Album(
    val userId: Int,
    val id: Int,
    val title: String
) {
    fun belongsToUser(userId: Int): Boolean {
        return this.userId == userId
    }
}
