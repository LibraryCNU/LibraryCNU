package com.collathon.librarycnu.shared.domain.entity

import kotlinx.datetime.LocalTime

data class Seat (
    val id: Int,
    val place: String,
    val plugExistence: Boolean,
    val startTime: LocalTime,
    val endTime: LocalTime,
    val canReserve: Boolean,
    val isFavorite: Boolean,
)
