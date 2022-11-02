package com.collathon.librarycnu.shared.domain.entity

import kotlinx.datetime.LocalTime

data class ReservationInfo (  // @Todo fix this.
    val id: Int,
    val place: String,
    val startTime: LocalTime,
    var endTime: LocalTime,
)
