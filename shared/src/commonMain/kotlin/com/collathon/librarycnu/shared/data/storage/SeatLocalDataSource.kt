package com.collathon.librarycnu.shared.data.storage

import com.collathon.librarycnu.shared.data.SeatDataSource
import com.collathon.librarycnu.shared.data.model.ReservationModel
import com.collathon.librarycnu.shared.data.model.SeatModel

class SeatLocalDataSource(private val database: Database) : SeatDataSource {
    override suspend fun fetchAllSeatInfo(): List<SeatModel> {
        TODO("Not yet implemented")
    }

    override suspend fun fetchSeatInfo(id: Int, place: String?): SeatModel {
        TODO("Not yet implemented")
    }

    override suspend fun reserveSeat(id: Int, place: String?): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun cancelSeat(id: Int, place: String?): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun extendSeat(id: Int, place: String?): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun fetchReservationInfo(id: Int, place: String?): ReservationModel {
        TODO("Not yet implemented")
    }

}
