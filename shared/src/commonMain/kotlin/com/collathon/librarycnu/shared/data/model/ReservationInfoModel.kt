package com.collathon.librarycnu.shared.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ReservationInfoModel (  // @Todo fix serial name.
    @SerialName("id")
    val id: Int,
    @SerialName("place")
    val place: String,
    @SerialName("assignedTime")
    val assignedTime: Long,  // @Todo fix time format.
    @SerialName("leftTime")
    var leftTime: Int,
)
