package com.collathon.librarycnu.shared.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SeatModel (  // @Todo fix serial name.
    @SerialName("id")
    val id: Int,
    @SerialName("place")
    val place: String,
    @SerialName("canReserve")
    val canReserve: Boolean,
    @SerialName("isFavorite")
    val isFavorite: Boolean,
)
