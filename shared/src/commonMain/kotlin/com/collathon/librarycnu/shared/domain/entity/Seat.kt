package com.collathon.librarycnu.shared.domain.entity

data class Seat (
    val id: Int,
    val place: String,
    val canReserve: Boolean,
    val isFavorite: Boolean,
)
