package com.collathon.librarycnu.shared.domain.repository

import com.collathon.librarycnu.shared.domain.entity.ReservationInfo
import com.collathon.librarycnu.shared.domain.entity.Seat

interface SeatRepository {
    suspend fun fetchAllSeatInfo(): List<Seat>
    suspend fun fetchSeatInfo(id: Int, place: String): Seat
    suspend fun reserveSeat(session: String, id: Int, place: String): Boolean
    suspend fun cancelSeat(session: String, id: Int, place: String): Boolean
    suspend fun extendSeat(session: String, id: Int, place: String): Boolean
    suspend fun fetchReservationInfo(session: String): ReservationInfo
}
