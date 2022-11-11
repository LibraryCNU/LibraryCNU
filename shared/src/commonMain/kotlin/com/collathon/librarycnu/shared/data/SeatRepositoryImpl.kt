package com.collathon.librarycnu.shared.data

import com.collathon.librarycnu.shared.data.model.ReservationModel
import com.collathon.librarycnu.shared.data.model.SeatModel
import com.collathon.librarycnu.shared.domain.entity.ReservationInfo
import com.collathon.librarycnu.shared.domain.entity.Seat
import com.collathon.librarycnu.shared.domain.repository.SeatRepository

class SeatRepositoryImpl(
    private val localSeatDataSource: SeatDataSource,
    private val remoteSeatDataSource : SeatDataSource
    ) : SeatRepository {
    override suspend fun fetchAllSeatInfo(): List<Seat> {
        val seatModelList: List<SeatModel> = remoteSeatDataSource.fetchAllSeatInfo()
        val seatList: ArrayList<Seat> = ArrayList<Seat>()

        for (seatModel in seatModelList) {
            seatList.add(Seat(
                seatModel.id,
                seatModel.place,
                seatModel.plugExistence,
                seatModel.startTime,
                seatModel.endTime,
                seatModel.canReserve,
                seatModel.isFavorite
            ))
        }

        return seatList.toList()
    }

    override suspend fun fetchSeatInfo(id: Int, place: String): Seat {
        val seatModel: SeatModel = remoteSeatDataSource.fetchSeatInfo(id = id, place = place)
        return Seat(
            seatModel.id,
            seatModel.place,
            seatModel.plugExistence,
            seatModel.startTime,
            seatModel.endTime,
            seatModel.canReserve,
            seatModel.isFavorite
        )
    }

    override suspend fun reserveSeat(id: Int, place: String): Boolean {
        return remoteSeatDataSource.reserveSeat(id = id, place = place)
    }

    override suspend fun cancelSeat(id: Int, place: String): Boolean {
        return remoteSeatDataSource.cancelSeat(id = id, place = place)
    }

    override suspend fun extendSeat(id: Int, place: String): Boolean {
        return remoteSeatDataSource.extendSeat(id = id, place = place)
    }

    override suspend fun fetchReservationInfo(id: Int, place: String): ReservationInfo {
        val reservationModel: ReservationModel =
            remoteSeatDataSource.fetchReservationInfo(id = id, place = place)
        return ReservationInfo(
            reservationModel.startTime,
            reservationModel.endTime,
            reservationModel.canReserve
        )
    }

}
