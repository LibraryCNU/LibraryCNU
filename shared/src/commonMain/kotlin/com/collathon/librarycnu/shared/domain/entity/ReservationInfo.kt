
package com.collathon.librarycnu.shared.domain.entity

import kotlinx.datetime.LocalDateTime

data class ReservationInfo(  // @Todo fix this.
    val startTime: LocalDateTime,
    var endTime: LocalDateTime,
    val canReserve: Boolean,
)

