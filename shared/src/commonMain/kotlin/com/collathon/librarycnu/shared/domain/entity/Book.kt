package com.collathon.librarycnu.shared.domain.entity

data class Book (  // @Todo fix this.
    val author: String,
    val name: String,
    val publish: String,
    val isbn: String,
    val language: String?,
    val picture: String?,  // url
    val isFavorite: Boolean,
)
