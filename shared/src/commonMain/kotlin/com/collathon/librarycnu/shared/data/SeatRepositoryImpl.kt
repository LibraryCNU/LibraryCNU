package com.collathon.librarycnu.shared.data

import com.collathon.librarycnu.shared.data.network.SeatRemoteDataSource
import com.collathon.librarycnu.shared.domain.entity.ReservationInfo
import com.collathon.librarycnu.shared.domain.entity.Seat
import com.collathon.librarycnu.shared.domain.repository.SeatRepository

class SeatRepositoryImpl(
    private val localSeatDataSource: SeatDataSource,
    private val remoteSeatDataSource : SeatDataSource
    ) : SeatRepository {
    override suspend fun fetchAllSeatInfo(): List<Seat> {
        TODO("Not yet implemented")
    }

    override suspend fun fetchSeatInfo(id: Int, place: String): Seat {
        TODO("Not yet implemented")
    }

    override suspend fun reserveSeat(session: String, id: Int, place: String): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun cancelSeat(session: String, id: Int, place: String): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun extendSeat(session: String, id: Int, place: String): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun fetchReservationInfo(session: String): ReservationInfo {
        TODO("Not yet implemented")
    }

}
