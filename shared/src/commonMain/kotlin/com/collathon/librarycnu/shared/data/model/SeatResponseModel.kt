package com.collathon.librarycnu.shared.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SeatResponseModel (  // @Todo fix serial name.
    @SerialName("id")
    val id: Int,
    @SerialName("place")
    val place: String,
    @SerialName("plug_existence")
    val plugExistence: Boolean,
    @SerialName("start_time")
    var startTime: String,
    @SerialName("end_time")
    val endTime: String,
    @SerialName("can_reserve")
    val canReserve: Boolean,
    @SerialName("is_favorite")
    val isFavorite: Boolean,
)
