
package com.collathon.librarycnu.shared.data.model

import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SeatModel (  // @Todo fix serial name.
    @SerialName("id")
    val id: Int,
    @SerialName("place")
    val place: String,
    @SerialName("plug_existence")
    val plugExistence: Boolean,
    @SerialName("start_time")
    val startTime: LocalDateTime,
    @SerialName("end_time")
    val endTime: LocalDateTime,
    @SerialName("can_reserve")
    val canReserve: Boolean,
    @SerialName("is_favorite")
    val isFavorite: Boolean,
)
