
package com.collathon.librarycnu.shared.domain.entity

import kotlinx.datetime.LocalTime

data class ReservationInfo (  // @Todo fix this.
    val startTime: LocalTime,
    var endTime: LocalTime,
    val canReserve: Boolean,
)

