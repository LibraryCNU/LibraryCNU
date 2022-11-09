
package com.collathon.librarycnu.shared.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BookModel (  // @Todo fix serial name.
    @SerialName("author")
    val author: String,
    @SerialName("name")
    val name: String,
    @SerialName("publish")
    val publish: String,
    @SerialName("isbn")
    val isbn: String,
    @SerialName("language")
    val language: String?,
    @SerialName("picture")
    val picture: String?,  // url
    @SerialName("is_favorite")
    val isFavorite: Boolean,
)
