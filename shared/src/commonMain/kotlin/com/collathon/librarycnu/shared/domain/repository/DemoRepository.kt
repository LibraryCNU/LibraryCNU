package com.collathon.librarycnu.shared.domain.repository

interface DemoRepository {
    suspend fun setReserveSeatLED(): Unit
    suspend fun setSearchBookLED(): Unit
}
