package com.collathon.librarycnu.shared.domain.entity

data class ReservationInfo (  // @Todo fix this.
    val id: Int,
    val place: String,
    val assignedTime: Long,
    var leftTime: Int,
)
