package com.collathon.librarycnu.shared.data

interface DemoDataSource {
    suspend fun setReserveSeatLED(): Unit
    suspend fun setSearchBookLED(): Unit
}
