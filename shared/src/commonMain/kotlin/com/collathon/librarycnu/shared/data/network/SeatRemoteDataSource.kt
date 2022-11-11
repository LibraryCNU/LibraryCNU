package com.collathon.librarycnu.shared.data.network

import OperationResponseModel
import com.collathon.librarycnu.shared.data.SeatDataSource
import com.collathon.librarycnu.shared.data.model.ReservationModel
import com.collathon.librarycnu.shared.data.model.SeatModel

class SeatRemoteDataSource(private val seatApi: SeatApi) : SeatDataSource {
    override suspend fun fetchAllSeatInfo(): List<SeatModel> {
        return seatApi.getAllSeatInfo()
    }

    override suspend fun fetchSeatInfo(id: Int, place: String?): SeatModel {
        return seatApi.getSeatInfo(id = id, place = place)
    }

    override suspend fun reserveSeat(id: Int, place: String?): Boolean {
        val result: OperationResponseModel = seatApi.reserveSeat(id = id, place = place)
        return result.result
    }

    override suspend fun cancelSeat(id: Int, place: String?): Boolean {
        val result: OperationResponseModel = seatApi.cancelSeat(id = id, place = place)
        return result.result
    }

    override suspend fun extendSeat(id: Int, place: String?): Boolean {
        val result: OperationResponseModel = seatApi.extendSeat(id = id, place = place)
        return result.result
    }

    override suspend fun fetchReservationInfo(id: Int, place: String?): ReservationModel {
        return seatApi.getReservationInfo(id = id, place = place)
    }

}
