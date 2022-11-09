
package com.collathon.librarycnu.shared.domain.entity

import kotlinx.datetime.LocalDateTime

data class Seat (
    val id: Int,
    val place: String,
    val plugExistence: Boolean,
    val startTime: LocalDateTime,
    val endTime: LocalDateTime,
    val canReserve: Boolean,
    val isFavorite: Boolean,
)
