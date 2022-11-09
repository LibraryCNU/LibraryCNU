package com.collathon.librarycnu.shared.data.model

import kotlinx.datetime.LocalTime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ReservationInfoModel (  // @Todo fix serial name.
    @SerialName("start_time")
    val startTime: LocalTime,
    @SerialName("end_time")
    val endTime: LocalTime,
    @SerialName("can_reserve")
    val canReserve: Boolean,
)
