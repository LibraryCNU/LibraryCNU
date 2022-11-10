package com.collathon.librarycnu.shared.data

import com.collathon.librarycnu.shared.data.model.ReservationModel
import com.collathon.librarycnu.shared.data.model.SeatModel

interface SeatDataSource {
    suspend fun fetchAllSeatInfo(): List<SeatModel>
    suspend fun fetchSeatInfo(id: Int, place: String?): SeatModel
    suspend fun reserveSeat(id: Int, place: String?): Boolean
    suspend fun cancelSeat(id: Int, place: String?): Boolean
    suspend fun extendSeat(id: Int, place: String?): Boolean
    suspend fun fetchReservationInfo(id: Int, place: String?): ReservationModel
}
